package com.example.reader.logic.model

import com.google.gson.annotations.SerializedName

class NovelModel (
    val msg:String,
    val code:Int,
    val success:Boolean,
    val data:NovelDataModel.Book
    )