package com.example.reader.logic.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NovelDataModel (
    val data:List<Book>, val msg:String, val success:Boolean, val code:Int) {

    data class Book(var id: Int, val name: String, var like_num: Int, val image: String, var content: String, val introduction: String):Serializable
}

