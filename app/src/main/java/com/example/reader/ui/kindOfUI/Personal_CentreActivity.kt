package com.example.reader.ui.kindOfUI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reader.R
import com.example.reader.logic.global.GlobalVarible
import com.example.reader.logic.model.DataKey
import com.example.reader.logic.model.NovelDataModel
import com.example.reader.logic.model.NullDataModel
import com.example.reader.logic.model.UserDataModel
import com.example.reader.logic.network.ApiClient
import com.example.reader.ui.KindOfAdapter.CollectionRecyclerView
import com.example.reader.ui.KindOfAdapter.DownLoadRecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Personal_CentreActivity : AppCompatActivity() {
    private lateinit var name:TextView
    private lateinit var token:TextView
    private lateinit var collectionRecyclerView: RecyclerView
    private lateinit var downloadRecyclerView: RecyclerView
    private lateinit var logout:Button
    private lateinit var logIn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_centre)
        //绑定
        name=findViewById(R.id.PCnameTextVIew)
        token=findViewById(R.id.PCtakenTextVIew)
        collectionRecyclerView=findViewById(R.id.PCcollectionRecyclerView)
        downloadRecyclerView=findViewById(R.id.PCdownloadRecyclerView)
        logout=findViewById(R.id.PCbutton)
        logIn=findViewById(R.id.PCLogInButton)
            //设置横向滚动
            val layoutManager = LinearLayoutManager(this)
            layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        //初始化
        initList()
        //收藏列表
        collectionRecyclerView.layoutManager=layoutManager
        val adapter = CollectionRecyclerView(this,GlobalVarible.collectionBook)
        collectionRecyclerView.adapter=adapter
        adapter.setOnItemClickeListener(object: CollectionRecyclerView.OnItemClickListenner {
            override fun onItemClike(position: Int) {
                var intent = Intent(this@Personal_CentreActivity,DisplayActivity::class.java)
                intent.putExtra("NovelInformation",GlobalVarible.collectionBook[position])
                startActivity(intent)
                finish()
            }
        })
        //下载列表
        val LayoutManager = LinearLayoutManager(this)
        LayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        downloadRecyclerView.layoutManager=LayoutManager
        val downloadAdapter=DownLoadRecyclerView(this,GlobalVarible.downLoadBook)
        downloadRecyclerView.adapter=downloadAdapter
        downloadAdapter.setOnItemClickeListener(object: DownLoadRecyclerView.OnItemClickListenner {
            override fun onItemClike(position: Int) {
                var intent = Intent(this@Personal_CentreActivity,DisplayActivity::class.java)
                intent.putExtra("NovelInformation",GlobalVarible.collectionBook[position])
                startActivity(intent)
                finish()
            }
        })
        //登出
        logout.setOnClickListener {
            val str=R.drawable.loading.toString()
            val OutLinelist= listOf(NovelDataModel.Book(1,"1",1,str,"1","1"))
            val OutLineUser= UserDataModel.User(111,"114","one", OutLinelist,"YuanYe")
            GlobalVarible.User=OutLineUser
            GlobalVarible.collectionBook.clear()
            var responseCode=LogOut()
            if (responseCode==200)Toast.makeText(this,"成功退出",Toast.LENGTH_SHORT).show()
            else Toast.makeText(this,"退出失败,请检查网络",Toast.LENGTH_SHORT).show()
        }
        //登入
        logIn.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
    //网络模块
    private fun LogOut():Int {
        var code = 111
        var data= DataKey(GlobalVarible.User.token)
        val call:Call<NullDataModel> = ApiClient.getClient.logout(data)
        call.enqueue(object :Callback<NullDataModel>{
            override fun onResponse(call: Call<NullDataModel>, response: Response<NullDataModel>) {
                response?.let {
                    it.body()?.let {
                        code=it.code
                    }
                }
            }
            override fun onFailure(call: Call<NullDataModel>, t: Throwable) {
                Log.d("message","LogUOutFalse")
            }

        })
        return code
    }
    //重置全局内容
    private fun initList() {
        name.setText(GlobalVarible.User.account)
        token.setText(GlobalVarible.User.token)
    }
    //测试方法，未成功
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            10 -> if (resultCode == RESULT_OK) {
                var returnedData = data?.getSerializableExtra("NovelInformation") as NovelDataModel.Book
                GlobalVarible.downLoadBook.add(returnedData)
                downloadRecyclerView.adapter?.notifyDataSetChanged()
            }
            10 ->if (resultCode== RESULT_CANCELED){
                Log.d("message","GetNovelInformationfalse")
            }
            9 -> if (resultCode == RESULT_OK) {
                var returnedData = data?.getSerializableExtra("NovelInformation") as NovelDataModel.Book
                GlobalVarible.downLoadBook.add(returnedData)
                collectionRecyclerView.adapter?.notifyDataSetChanged()
            }
            9 ->if (resultCode== RESULT_CANCELED){
                Log.d("message","GetNovelInformationfalse")
            }

        }
    }
}