package com.example.reader.ui.kindOfUI

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.reader.MainActivity
import com.example.reader.R
import com.example.reader.logic.global.GlobalVarible
import com.example.reader.logic.model.Data
import com.example.reader.logic.model.DataKey
import com.example.reader.logic.model.NovelDataModel
import com.example.reader.logic.model.UserDataModel
import com.example.reader.logic.network.ApiClient
import com.example.reader.logic.network.ApiInterface
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.concurrent.thread
import okhttp3.RequestBody




class LoginActivity : AppCompatActivity() {
    private lateinit var Login: Button
    private lateinit var Register:Button
    private lateinit var Account:EditText
    private lateinit var password:EditText
    private lateinit var url:EditText
    private lateinit var testMode:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //绑定
        Login=findViewById(R.id.LoginButton)
        Register=findViewById(R.id.RegisterButton)
        Account=findViewById(R.id.editTextTextPersonName)
        password=findViewById(R.id.editTextTextPassword)
        testMode=findViewById(R.id.LogInTestButton)
        url=findViewById(R.id.editTextURL)
        //登入
        Login.setOnClickListener {
         getData(Account.text.toString(),password.text.toString())
            if (GlobalVarible.Online) {
                //登入成功并将用户数据回传至主页面
                Toast.makeText(this,"登入成功，正在跳转",Toast.LENGTH_SHORT).show()
                var intent = Intent(this,MainActivity::class.java)
                intent.putExtra("UserInformation", GlobalVarible.User)
                setResult(RESULT_OK, intent)
                startActivity(intent)
                finish()
            }
            else Toast.makeText(this,"账号或密码错误/未连接至网络",Toast.LENGTH_SHORT).show()
        }
        //注册并跳转至注册界面
        Register.setOnClickListener {
            var intent=Intent(this,RegisterActivity::class.java)
            startActivityForResult(intent,1)
            if (GlobalVarible.Online) {

                Toast.makeText(this,"登入成功，正在跳转",Toast.LENGTH_SHORT).show()
                var intent = Intent()
                intent.putExtra("UserInformation", GlobalVarible.User)
                setResult(RESULT_OK, intent)
                finish()
            }
            else Toast.makeText(this,"账号或密码错误/未连接至网络",Toast.LENGTH_SHORT).show()
        }
        //游客模式
        testMode.setOnClickListener {
            //在离线模式下运行该程序
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            GlobalVarible.Online=false
            GlobalVarible.LocalMode=true
            finish()
        }
        //传入url
        url.addTextChangedListener (object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                var str=p0.toString()
                GlobalVarible.url=str
                Log.d("message",GlobalVarible.url)
            }
        })
    }

    private fun getData(name:String,password:String){
        //json文件中包含有小说的content和image两块信息导致文件内容占用过大，需要读取后再转义，难度过大，目前无法实现
        var data=Data(name,password)
        val call:Call<UserDataModel> =ApiClient.getClient.loginByAccount(data)
        call.enqueue(object :Callback<UserDataModel>{
            override fun onResponse(call: Call<UserDataModel>, response: Response<UserDataModel>) {
                response?.let {
                    it.body()?.let {
                        if(it.code==200) {
                            GlobalVarible.User=it.data
                            Log.d("message","登入成功")
                            for (x in it.data.collBooks) { GlobalVarible.collectionBook.add(x) }
                            GlobalVarible.Online=true//设置为联网状态
                            GlobalVarible.LocalMode=false//禁用本地模式
                            getBookData()
                        }
                    }
                }
            }
            override fun onFailure(call: Call<UserDataModel>, t: Throwable) {
                return
            }

        })
    }
    //设置页面间传输参数
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val returnedData = data?.getSerializableExtra("UserInformation") as UserDataModel.User
            }
            1 ->if (resultCode== RESULT_CANCELED){
                Log.d("message","GetUpInformationfalse")
            }
        }
    }
    private fun getBookData(){
        //今天忙了一天，还是很遗憾解决不了报错问题，不过我觉得我理清了一点原因，首先，
        //因为小说的内容数据量比较大，而且后端传输的时候是以所有小说的各类数据（包含小说的内容和图片）一并传过来，导致缓存不足（猜测）的情况。
        //故，尝试采用先读取json内容，然后再进行转换的方式进行读取，设计及代码如下所示。但是这个结构还是有bug，目前实现不了
        thread{
            var json = JSONArray()
            val interceptor= HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            var client = OkHttpClient.Builder().addInterceptor(interceptor).build()//拦截器
            // val requestBody = FormBody.Builder().add("name", name).add("password", password).build()
            var obj=JsonObject()//写入json文件
            try {
                obj.addProperty("token",GlobalVarible.User.token)
            } catch (e:JSONException) {
                e.printStackTrace()
            }
            val type = MediaType.parse("application/json;charset=utf-8")
            val requestBody = RequestBody.create(type, "" + obj.toString())//将json文件添加至body中以满足后端需求
            val request =
                Request.Builder().url(GlobalVarible.url+"/Common_war_exploded/sb/findAllBooks").post(requestBody)
                    .build()//构建请求
            val response = client.newCall(request).execute()//执行请求
            val responseString = response.body()?.string()
            if (responseString !== null) {
                try {GlobalVarible.Online=true
                    val output = openFileOutput("data", Context.MODE_PRIVATE)
                    var writer = BufferedWriter(OutputStreamWriter(output))
                    writer.use {
                        it.write(responseString)//读入json文件并以string方式保存
                    }
                    writer.close()
                    val input = openFileInput("data")
                    val reader = BufferedReader(InputStreamReader(input))
                    reader.use {
                        reader.forEachLine {
                            json = JSONArray(it)//目前猜测出错的地方,即以JSONArray的形式读取String
                        }
                        for (i in 0 until json.length()) {//开始转义JSON文件
                            val JB = json.getJSONObject(i)
                            for (i in 0 until json.length()) {
                                GlobalVarible.collectionBook.add(
                                    NovelDataModel.Book(
                                        JB.getInt("id"),
                                        JB.getString("name"),
                                        JB.getInt("like_num"),
                                        JB.getString("image"),
                                        JB.getString("content"),
                                        JB.getString("introduction")
                                    )
                                )
                            }
                        }
                    }
                    reader.close()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

    }
}