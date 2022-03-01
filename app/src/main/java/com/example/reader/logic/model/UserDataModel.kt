package com.example.reader.logic.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class UserDataModel (
    val data:User,
    val msg:String,
    val code:Int,
    val success:Boolean)
{
   data class User(var id:Int,
                   var password: String,
                   var token: String,
                   val collBooks:List<NovelDataModel.Book>,
                   var account: String): Serializable
}