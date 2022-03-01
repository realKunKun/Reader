package com.example.reader.ui.kindOfUI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import com.example.reader.R
import com.example.reader.logic.model.NovelDataModel

class ReaderActivity : AppCompatActivity() {
    private lateinit var book:NovelDataModel.Book
    private var contentList=ArrayList<String>()
    lateinit var readTextView:TextView
    private var page:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reader)
        //绑定
        book =intent.getSerializableExtra("content")as NovelDataModel.Book
        readTextView=findViewById(R.id.ReadtextView)
        var readScrollView:ScrollView=findViewById(R.id.readScrollView)
        var previousPage:Button=findViewById(R.id.PreviousPage)
        var nextPage:Button=findViewById(R.id.NextPage)
        //设置
        separarte(book)
        readTextView.setText(contentList[page])
        previousPage.setOnClickListener {
            if (page==0)Toast.makeText(this,"这是第一页了",Toast.LENGTH_SHORT).show()
            else {
                readTextView.setText(contentList[--page])
                Toast.makeText(this,"第${page+1} 页",Toast.LENGTH_SHORT).show()
            }
        }
        nextPage.setOnClickListener {
            if (page==contentList.size-1)Toast.makeText(this,"这是最后一页了",Toast.LENGTH_SHORT).show()
            else {
                readTextView.setText(contentList[++page])
                Toast.makeText(this,"第${page+1} 页",Toast.LENGTH_SHORT).show()
            }
        }
    }
    //分割文章，默认
    private fun separarte(book:NovelDataModel.Book){
        var book:NovelDataModel.Book=book
        while (book.content.length>999){
            contentList.add(book.content.substring(0,999))
            book.content=book.content.substring(999,book.content.length)
        }
        contentList.add(book.content)
    }
}