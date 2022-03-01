package com.example.reader.logic.network

import android.util.Log
import com.example.reader.logic.global.GlobalVarible
import com.google.gson.GsonBuilder
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.internal.tls.OkHostnameVerifier
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    var Url:String="https://c3de-120-36-50-161.jp.ngrok.io"
    val getClient:ApiInterface
    get() {
        val gson=GsonBuilder()
            .setLenient()
            .create()
        val interceptor=HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        var client=OkHttpClient.Builder()
            .apply {cookieJar(object :CookieJar{
            override fun saveFromResponse(url: HttpUrl, cookies: MutableList<Cookie>) {
              for (x in cookies) GlobalVarible.cookieList.add(x)
                if (!GlobalVarible.cookieList.isEmpty()) Log.d("SaveMessage","${GlobalVarible.cookieList.last()}")
            }
            override fun loadForRequest(url: HttpUrl): MutableList<Cookie> {
                if (!GlobalVarible.cookieList.isEmpty()) Log.d("LoadMessage","${GlobalVarible.cookieList.last()}")
               return GlobalVarible.cookieList
            } }) }
            .addInterceptor(interceptor).build()
        val retrofit=Retrofit.Builder()
            .baseUrl(Url)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit.create(ApiInterface::class.java)
    }
}