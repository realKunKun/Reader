package com.example.reader.ui.kindOfUI

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.widget.Toolbar
import androidx.room.Room
import com.bumptech.glide.Glide
import com.example.reader.R
import com.example.reader.logic.dao.Database
import com.example.reader.logic.global.GlobalVarible
import com.example.reader.logic.model.*
import com.example.reader.logic.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DisplayActivity : AppCompatActivity() {
    private lateinit var book:NovelDataModel.Book
    private lateinit var likeTextView: TextView
    private lateinit var database: Database
    private lateinit var localBook:NovelDataModel.Book
    private var hasLiked=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        //接受数据
        book=intent.getSerializableExtra("NovelInformation") as NovelDataModel.Book
        //绑定数据
        var NovelName:TextView=findViewById(R.id.DisplaytextView)
        var NovelIntroduce:TextView=findViewById(R.id.DisplaytextView3)
        var NovelImage:ImageView=findViewById(R.id.DisplayimageView)
        var BeginRead:Button=findViewById(R.id.Displaybutton)
        var DownLoad:Button=findViewById(R.id.DisplayDownLoadbutton)
        var LocalRead:Button=findViewById(R.id.DisplayLocalReadButton)
        var toolbar:Toolbar=findViewById(R.id.DisplayToolbar)
        likeTextView=findViewById(R.id.DIsplayLikeTextView)
        //Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeButtonEnabled(true)
        }




        //设置
        NovelName.setText("作者: "+book.name)
        NovelIntroduce.setText(book.introduction)
        //使用网络静态资源
        if(!GlobalVarible.Online) Glide.with(this).load("https://qlogo4.store.qq.com/qzone/3238127737/3238127737/100?1610538198").into(NovelImage)
        else {
            Glide.with(this).load(book.image).into(NovelImage)
        }
        likeTextView.setText("点赞数: ${book.like_num}")
        //跳转开始阅读
        BeginRead.setOnClickListener {
            var intent=Intent(this,ReaderActivity::class.java)
            intent.putExtra("content",book)
            startActivity(intent)
        }
        //数据库
        database=Room.databaseBuilder(applicationContext,Database::class.java,"NovelDataBase").allowMainThreadQueries().build()
        //下载按钮
        DownLoad.setOnClickListener {
            if(!GlobalVarible.LocalMode) {
                var responseCode = DownLoadData(book.name)
                if (responseCode == 200) {
                    database.dataDao()
                        .insertNovel(novelEntity = NovelEntity(book.id, book.name, book.content))
                    Toast.makeText(
                        this,
                        "下载中，书名是： ${database.dataDao().getNovel(book.name)}",
                        Toast.LENGTH_SHORT
                    ).show()
                    if (!GlobalVarible.downLoadBook.contains(book)) {
                        GlobalVarible.downLoadBook.add(book)
                    }
                } else if (responseCode == 510) Toast.makeText(this, "重新登入", Toast.LENGTH_SHORT)
                    .show()
                else if (responseCode == 404) Toast.makeText(this, "无此书", Toast.LENGTH_SHORT).show()
                else {
                    Toast.makeText(this, "无网络连接", Toast.LENGTH_SHORT).show()
                }
            }
            //添加至个人中心下载列表
            var intentToPC=Intent(this,Personal_CentreActivity::class.java)
            intentToPC.putExtra("NovelInformation",book)
            setResult(10,intentToPC)
        }
        //本地阅读
        LocalRead.setOnClickListener {
            if (!GlobalVarible.Online || GlobalVarible.LocalMode)  {
                //测试数据
                if (!GlobalVarible.downLoadBook.contains(book)){
                    GlobalVarible.downLoadBook.add(book)
                }
                Toast.makeText(this, "无网络连接，将使用本地测试数据", Toast.LENGTH_SHORT).show()
                database.dataDao().insertNovel(novelEntity = NovelEntity(book.id,"模拟长篇",GlobalVarible.Textlocal))
                localBook=GlobalVarible.collectionBook[0]
                localBook.content=database.dataDao().getNovel("模拟长篇")}
            else {
                Toast.makeText(this, "下载成功，开始阅读", Toast.LENGTH_SHORT).show()
                localBook.content = database.dataDao().getNovel(book.name)
            }
            //传送至Display页面
            var intent=Intent(this,ReaderActivity::class.java)
            intent.putExtra("content",localBook)
            startActivity(intent)
            finish()
        }
    }
    //点赞网络接口
    private fun getLikeData(id:Int):String {
        var str=""
        var data=DataLike(id,GlobalVarible.User.token)
        val call:Call<LikeDataModel> =ApiClient.getClient.addLike(data)
        call.enqueue(object :Callback<LikeDataModel>{
            override fun onResponse(call: Call<LikeDataModel>, response: Response<LikeDataModel>) {
                GlobalVarible.Online=true
                response?.let {
                    it.body()?.let {
                        book.like_num=it.like
                        likeTextView.setText(book.like_num.toString())
                        str=it.msg
                    }
                }
            }
            override fun onFailure(call: Call<LikeDataModel>, t: Throwable) {
                Log.d("message","false")
                str="无网络连接"
            }

        })
        return str
    }
    //下载网络接口
    private fun DownLoadData(keyWord: String):Int{
        var code:Int=111
        var data=Databook(keyWord,GlobalVarible.User.token)
        val call:Call<NovelModel> =ApiClient.getClient.findBook(data)
        call.enqueue(object :Callback<NovelModel>{
            override fun onResponse(call: Call<NovelModel>, response: Response<NovelModel>) {
                GlobalVarible.Online=true
                response?.let {
                    it.body()?.let {
                        if (it.code==200){
                            code=it.code
                            book=it.data
                        }
                        else if (it.code==510){
                            code=it.code
                        }
                        else code=it.code
                    } }

            }
            override fun onFailure(call: Call<NovelModel>, t: Throwable) {
                Log.d("message","false")
            }

        })
        return code
    }
    //收藏网络接口
    private fun getCollectionData(id:Int):String {
        var str=""
        var data=DataLike(id,GlobalVarible.User.token)
        val call:Call<NullDataModel> = ApiClient.getClient.addColl(data)
        call.enqueue(object :Callback<NullDataModel>{
            override fun onResponse(call: Call<NullDataModel>, response: Response<NullDataModel>) {
                response?.let {
                    it.body()?.let {
                        str=it.msg
                    }
                }
            }
            override fun onFailure(call: Call<NullDataModel>, t: Throwable) {
                Log.d("message","false")
                str="无网络连接"
            }

        })
        return str
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.like -> {//点赞
                if (GlobalVarible.LocalMode==false) {
                    var msg = getLikeData(book.id)
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT)
                    if (msg.equals("点赞成功")) {
                        if(!hasLiked){
                            book.like_num++
                            hasLiked=true}
                        likeTextView.setText("点赞数: ${book.like_num}")
                    } else if (msg.equals("已赞过")) {
                    } else if (msg.equals("点赞失败")) {
                        Toast.makeText(this, "未登入，正造跳转至登入界面", Toast.LENGTH_SHORT)
                        var intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                    } else Toast.makeText(this, "无网络链接", Toast.LENGTH_SHORT)
                }
                else{
                    Toast.makeText(this, "本地(再次点赞即可取消)", Toast.LENGTH_SHORT)
                    if(!hasLiked){
                        book.like_num++
                        hasLiked=true}
                    else{
                        book.like_num--
                        hasLiked=false
                    }
                    likeTextView.setText("点赞数: ${book.like_num}")
                }
            }
            R.id.collection -> {//收藏
                //测试数据
                if (GlobalVarible.LocalMode){ if (!GlobalVarible.collectionBook.contains(book)){
                    GlobalVarible.collectionBook.add(book)
                    Toast.makeText(this, "本地收藏", Toast.LENGTH_SHORT)
                }
                else{
                    GlobalVarible.collectionBook.remove(book)
                    Toast.makeText(this, "取消收藏", Toast.LENGTH_SHORT)
                }
                }
                //网络模块
                else{ if (getCollectionData(book.id).equals("收藏成功")) { Toast.makeText(this, "已收藏", Toast.LENGTH_SHORT)
                        if (!GlobalVarible.collectionBook.contains(book)) { GlobalVarible.collectionBook.add(book) }
                    } else if (getCollectionData(book.id).equals("取消收藏")) { Toast.makeText(this, "取消收藏", Toast.LENGTH_SHORT)
                        GlobalVarible.collectionBook.remove(book)
                    } else if (getCollectionData(book.id).equals("收藏失败")) { Toast.makeText(this, "收藏失败,未登入，正造跳转至登入界面", Toast.LENGTH_SHORT)
                        var intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                    } else Toast.makeText(this, "无网络", Toast.LENGTH_SHORT)
                }
            }
        }
        return true
    }
}