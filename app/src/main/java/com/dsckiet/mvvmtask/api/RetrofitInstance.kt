package com.dsckiet.mvvmtask.api
import com.dsckiet.mvvmtask.`interface`.apirequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    val api : apirequest by lazy {
        retrofit.create(apirequest::class.java)
    }

}