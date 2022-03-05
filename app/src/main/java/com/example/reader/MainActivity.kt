package com.example.reader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import android.widget.Toolbar
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.reader.logic.global.GlobalVarible
import com.example.reader.logic.model.DataKey
import com.example.reader.logic.model.NovelDataModel
import com.example.reader.logic.model.UserDataModel
import com.example.reader.logic.network.ApiClient
import com.example.reader.ui.KindOfAdapter.MainRecyclerView
import com.example.reader.ui.kindOfUI.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var MyRecyclerView:RecyclerView
    private lateinit var sortButton:Button
    private lateinit var personalCentre:Button
    private lateinit var progressBar: ProgressBar
    private var NovelList=ArrayList<NovelDataModel.Book>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar:androidx.appcompat.widget.Toolbar=findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        //初始化本地数据
        initList()
        //第一次检测用户是否登入
        if (!GlobalVarible.Online && !GlobalVarible.LocalMode){
            var intent=Intent(this,LoginActivity::class.java)
            startActivityForResult(intent,1)
            finish()
        }

            //RecyclerView
            MyRecyclerView=findViewById(R.id.MainRecyclerView)
            val layoutManager = StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL)
            MyRecyclerView.layoutManager = layoutManager
            val adapter = MainRecyclerView(this, NovelList)
            MyRecyclerView.adapter = adapter
            adapter.setOnItemClickeListener(object : MainRecyclerView.OnItemClickListenner {
                override fun onItemClike(position: Int) {
                    var intent = Intent(this@MainActivity, DisplayActivity::class.java)
                    intent.putExtra("NovelInformation", NovelList[position])
                    startActivity(intent)
                }
            })
        if (GlobalVarible.Online==true) //只有先登入，才进行书籍数据请求
        {
            Toast.makeText(this, "加载中", Toast.LENGTH_SHORT).show()
            progressBar = findViewById(R.id.MainprogressBar)
            progressBar.isVisible = true
            progressBar.incrementProgressBy(10)
            NovelList.clear()
            for (x in GlobalVarible.BookList) { NovelList.add(x) }//将收到的小说数据置入并刷新适配器
            MyRecyclerView.adapter?.notifyDataSetChanged()
            progressBar.max
        }
        //搜索功能
        sortButton=findViewById(R.id.MainSortButton)
        sortButton.setOnClickListener{
                var intent = Intent(this@MainActivity, SortActivity::class.java)
                intent.putExtra("NovelList", NovelList)
                startActivity(intent)
        }
        //个人中心
        personalCentre=findViewById(R.id.MainPersonalCentreButton)
        personalCentre.setOnClickListener {
            var intent = Intent(this@MainActivity, Personal_CentreActivity::class.java)
            intent.putExtra("UserInformation", GlobalVarible.User)
            startActivity(intent)
        }
    }
    //本地信息初始化
    private fun initList() {
        //初始化本地参数
            val str = R.drawable.loading.toString()
            NovelList.add(
                NovelDataModel.Book(
                    114,
                    "子曰",
                    514,
                    str,
                    GlobalVarible.Texttest,
                    GlobalVarible.introduction
                )
            )
            NovelList.add(
                NovelDataModel.Book(
                    114,
                    "衣衣事",
                    514,
                    str,
                    GlobalVarible.Texttest,
                    GlobalVarible.introduction
                )
            )
            NovelList.add(
                NovelDataModel.Book(
                    114,
                    "吾衣是",
                    514,
                    str,
                    GlobalVarible.Texttest,
                    GlobalVarible.introduction
                )
            )
            NovelList.add(
                NovelDataModel.Book(
                    114,
                    "依旧",
                    514,
                    str,
                    GlobalVarible.Texttest,
                    GlobalVarible.introduction
                )
            )
            NovelList.add(
                NovelDataModel.Book(
                    114,
                    "依旧",
                    514,
                    str,
                    GlobalVarible.Texttest,
                    GlobalVarible.introduction
                )
            )
            NovelList.add(
                NovelDataModel.Book(
                    114,
                    "罢矣凛",
                    514,
                    str,
                    GlobalVarible.Texttest,
                    GlobalVarible.introduction
                )
            )
            NovelList.add(
                NovelDataModel.Book(
                    114,
                    "罢矣凛",
                    514,
                    str,
                    GlobalVarible.Texttest,
                    GlobalVarible.introduction
                )
            )
            GlobalVarible.User = UserDataModel.User(111, "111", "JBJKEBEBHE", GlobalVarible.collectionBook, "测试账号")
        if (!GlobalVarible.once) {
            GlobalVarible.collectionBook.add(
                NovelDataModel.Book(
                    114,
                    "鲤鱼",
                    514,
                    str,
                    GlobalVarible.Texttest,
                    GlobalVarible.introduction
                )
            )
        GlobalVarible.once=true}
    }
    //设置页面间传输参数
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                //接受回传的用户数据
                var returnedData = data?.getSerializableExtra("UserInformation") as UserDataModel.User
                GlobalVarible.User=returnedData
            }
            1 ->if (resultCode== RESULT_CANCELED){
                Log.d("message","GetUpInformationfalse")
            }
        }
    }

}
