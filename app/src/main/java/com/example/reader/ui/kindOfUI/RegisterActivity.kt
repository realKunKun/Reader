package com.example.reader.ui.kindOfUI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.reader.R
import com.example.reader.logic.global.GlobalVarible
import com.example.reader.logic.model.Data
import com.example.reader.logic.model.NovelDataModel
import com.example.reader.logic.model.NullDataModel
import com.example.reader.logic.model.UserDataModel
import com.example.reader.logic.network.ApiClient
import com.example.reader.logic.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        //绑定
        var reAccount:EditText=findViewById(R.id.RegisterEditTextTextAccount)
        var rePassword:EditText=findViewById(R.id.RegisterEditTextTextPassword)
        var submit:Button=findViewById(R.id.RegisterButton)
        submit.setOnClickListener {
            var responseCode=getData(reAccount.text.toString(),rePassword.text.toString())
            if (responseCode==200){
                Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show()
                var intent = Intent()
                intent.putExtra("UserInformation", GlobalVarible.User)
                setResult(RESULT_OK, intent)
                finish()
            }
            else if (responseCode==500) Toast.makeText(this,"该账号已存在", Toast.LENGTH_LONG).show()
            else Toast.makeText(this,"无网络链接",Toast.LENGTH_LONG).show()
        }
    }
    //网络数据
    private fun getData(name:String,password:String):Int {
        var code = 111
        var data= Data(name,password)
        val call:Call<NullDataModel> =ApiClient.getClient.register(data)
        call.enqueue(object :Callback<NullDataModel>{
            override fun onResponse(call: Call<NullDataModel>, response: Response<NullDataModel>) {
                response?.let {
                    it.body()?.let {
                        if(it.code==200) {
                           // GlobalVarible.User=it.data//将新用户设置为当前用户
                            code=it.code
                        }
                        //其他情况
                        else{
                            code=500
                        }
                    }
                }
            }

            override fun onFailure(call: Call<NullDataModel>, t: Throwable) {
                Log.d("message","false")
            }
        })
        return code
    }
}