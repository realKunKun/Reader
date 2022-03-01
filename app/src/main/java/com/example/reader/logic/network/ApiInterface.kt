package com.example.reader.logic.network

import com.example.reader.logic.model.*
import com.google.gson.annotations.Expose
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.*

interface ApiInterface {
    //@Headers("Content-Type: application/json;charset=UTF-8")
    @POST("Common_war_exploded/sb/findAllBooks")
    fun findALlBook(@Body Data:DataKey)


    @POST("Common_war_exploded/su/loginByIdAndPassword")
    fun loginByID(@Body id:Int, password:String)//不使用该方法


    @POST("Common_war_exploded/su/loginByAccountAndPassword")
    fun loginByAccount(@Body data:Data)


    @POST("Common_war_exploded/su/register")
    fun register(@Body data:Data):Call<NullDataModel>


    @POST("Common_war_exploded/su/logOut")
    fun logout(@Body Data:DataKey):Call<NullDataModel>


    @POST("Common_war_exploded/sb/findBookByName")
    fun findBook(@Body data:Databook):Call<NovelModel>


    @POST("Common_war_exploded/sb/addLikes")
    fun addLike(@Body data:DataLike):Call<LikeDataModel>


    @POST("Common_war_exploded/su/addColl")
    fun addColl(@Body data:DataLike):Call<NullDataModel>
}