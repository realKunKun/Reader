package com.example.reader.ui.kindOfUI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reader.R
import com.example.reader.logic.model.NovelDataModel
import com.example.reader.ui.KindOfAdapter.SortRecyclerView

class SortActivity : AppCompatActivity() {
    private lateinit var searchView:SearchView
    private lateinit var RecyclerView:RecyclerView
    private var NovelList=ArrayList<NovelDataModel.Book>()
    private var sortList=ArrayList<NovelDataModel.Book>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sort)
        //传输
        NovelList=intent.getSerializableExtra("NovelList") as ArrayList<NovelDataModel.Book>
        //RecyclerView
        RecyclerView=findViewById(R.id.SortRecyclerView)
        RecyclerView.layoutManager=LinearLayoutManager(this)
        var adapter=SortRecyclerView(NovelList)
        RecyclerView.adapter = adapter
        adapter.setOnItemClickeListener(object: SortRecyclerView.OnItemClickListenner {
            override fun onItemClike(position: Int) {
                var intent = Intent(this@SortActivity,DisplayActivity::class.java)
                intent.putExtra("NovelInformation",NovelList[position])
                startActivity(intent)
            }
        })
        //searchView
        searchView=findViewById(R.id.searchView)
        //显示搜索框
        searchView.isIconifiedByDefault=false
        //可以被提交
        searchView.isSubmitButtonEnabled=true
        searchView.setQueryHint("查找")
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(keyWord: String): Boolean {
                filter(keyWord)
                RecyclerView.adapter?.notifyDataSetChanged()
                return false
            }
            override fun onQueryTextChange(keyWord: String): Boolean {

                return false
            }
        })
    }
    //本地搜索，测试阶段会写入searchView，最终提交作业时不包含在内，但是保留在这里
    private fun filter(keyWord: String) {
        // 过滤原本的列表，返回一个新的列表
        for (l in NovelList) {
            if (l.name.contains(keyWord)) sortList.add(l)
        }
        //val Iterator=NovelList.iterator()
        NovelList.clear()
        //while (Iterator.hasNext())NovelList.remove(Iterator.next())
        for (l in sortList) NovelList.add(l)
    }
    //网络调取信息：本地搜索可以做到模糊搜索，故不调用网络连接
}