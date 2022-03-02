package com.example.reader.ui.KindOfAdapter

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.reader.R
import com.example.reader.logic.global.GlobalVarible
import com.example.reader.logic.model.NovelDataModel

class DownLoadRecyclerView (val context: Context, var bookList:ArrayList<NovelDataModel.Book>): RecyclerView.Adapter<DownLoadRecyclerView.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Novelimage: ImageView = itemView.findViewById(R.id.NovelImage)
        val Novelname: TextView = itemView.findViewById(R.id.NovelText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val novel=bookList[position]
        //使用联网静态资源
        if(!GlobalVarible.Online)Glide.with(context).load("https://qlogo4.store.qq.com/qzone/3238127737/3238127737/100?1610538198").into(holder.Novelimage)
        else {
            Glide.with(context).load(novel.image).into(holder.Novelimage)
            //将ByteArray转换成bitmap
           // var bitmap = BitmapFactory.decodeByteArray(novel.image, 0, novel.image.size)
            //Glide.with(context).load(bitmap).into(holder.Novelimage)

        }

        holder.Novelname.setText(novel.name)
        holder.Novelimage.setOnClickListener {
            itemClickListenner?.onItemClike(position)
        }
        holder.Novelname.setOnClickListener {
            itemClickListenner?.onItemClike(position)
        }
    }

    override fun getItemCount()= bookList.size
    //点击事件接口
    private var itemClickListenner: OnItemClickListenner? = null
    fun setOnItemClickeListener(itemClickListenner: OnItemClickListenner) {
        this.itemClickListenner = itemClickListenner;
    }
    interface OnItemClickListenner {
        fun onItemClike(position: Int)
    }
}