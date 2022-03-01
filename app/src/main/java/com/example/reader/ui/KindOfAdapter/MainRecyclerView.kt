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

class MainRecyclerView(val context: Context,var bookList: List<NovelDataModel.Book>):RecyclerView.Adapter<MainRecyclerView.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Novelimage: ImageView = itemView.findViewById(R.id.MainRecyclerViewImageView)
        val Novelname: TextView = itemView.findViewById(R.id.MainRecyclerViewTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_recyclerview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainRecyclerView.ViewHolder, position: Int) {
       val novel=bookList[position]
        //使用glide动态加载图片
        if(!GlobalVarible.Online)Glide.with(context).load("https://qlogo4.store.qq.com/qzone/3238127737/3238127737/100?1610538198").into(holder.Novelimage)
        else {
            Glide.with(context).load(novel.image).into(holder.Novelimage)
            //var bitmap = BitmapFactory.decodeByteArray(novel.image, 0, novel.image.size)
            //Glide.with(context).load(bitmap).into(holder.Novelimage)
        }
        holder.Novelname.text=novel.name
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