package com.example.reader.logic.model

import com.google.gson.annotations.SerializedName

data class LikeDataModel (
    val msg:String,

    val code:Int,

    val success:Boolean,

    val like:Int
    )