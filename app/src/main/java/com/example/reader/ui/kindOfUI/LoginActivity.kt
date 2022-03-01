package com.example.reader.ui.kindOfUI

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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
import org.json.JSONArray
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

class LoginActivity : AppCompatActivity() {
    private lateinit var Login: Button
    private lateinit var Register:Button
    private lateinit var Account:EditText
    private lateinit var password:EditText
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
        //登入
        Login.setOnClickListener {
         getData(Account.text.toString(),password.text.toString())
            if (GlobalVarible.Online) {
                //登入成功并将用户数据回传至主页面
                GlobalVarible.Online=true//设置为联网状态
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
            GlobalVarible.Online=true
            finish()
        }
    }

    private fun getData(name:String,password:String){
      val client=OkHttpClient()
      val requestBody=FormBody.Builder().add("name",name).add("password",password).build()
      val request=Request.Builder().url("https://c3de-120-36-50-161.jp.ngrok.io").post(requestBody).build()
      val response=client.newCall(request).execute()
      val responseString=response.body()?.string()
      val jsonObject=JsonArray(responseString)
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
        var data=DataKey(GlobalVarible.User.token)
        val call: Call<NovelDataModel> = ApiClient.getClient.findALlBook(data)
        call.enqueue(object : Callback<NovelDataModel> {
            override fun onResponse(call: Call<NovelDataModel>, response: Response<NovelDataModel>
            ) {Log.d("message","登入成功")
                response?.let {
                    it.body()?.let {
                        if(it.code==200) {
                            //重置小说组并刷新数据
                            for (x in it.data) { GlobalVarible.BookList.add(x) }//将收到的小说数据置入并刷新适配器
                            Log.d("message",GlobalVarible.BookList[0].name)
                        }
                    } }
            }
            override fun onFailure(call: Call<NovelDataModel>, t: Throwable) {
                Log.d("message","登入页面网络连接失败")
            }
        })
    }
}