package com.example.reader.logic.global

import com.example.reader.logic.model.NovelDataModel
import com.example.reader.logic.model.UserDataModel
import okhttp3.Cookie

object GlobalVarible {
     var downLoadBook=ArrayList<NovelDataModel.Book>()
     var collectionBook=ArrayList<NovelDataModel.Book>()
     var Online:Boolean = false
     lateinit var User:UserDataModel.User
     var BookList=ArrayList<NovelDataModel.Book>()//临时设计的全局变量
      var cookieList= mutableListOf<Cookie>()
}