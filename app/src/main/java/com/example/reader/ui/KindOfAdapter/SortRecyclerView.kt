package com.example.reader.ui.KindOfAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reader.R
import com.example.reader.logic.model.NovelDataModel

class SortRecyclerView(var chapterList:List<NovelDataModel.Book>): RecyclerView.Adapter<SortRecyclerView.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val context: TextView = itemView.findViewById(R.id.recyclerViewSortTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sort_recyclerview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = chapterList[position]
        holder.context.text=item.name
        // 给每个holder添加一个点击事件
        holder.context.setOnClickListener {
            itemClickListenner?.onItemClike(position)
        }
    }

    override fun getItemCount()= chapterList.size
    //点击事件接口
    private var itemClickListenner: OnItemClickListenner? = null
    fun setOnItemClickeListener(itemClickListenner: SortRecyclerView.OnItemClickListenner) {
        this.itemClickListenner = itemClickListenner
    }
     interface OnItemClickListenner {
        fun onItemClike(position: Int)
    }

}