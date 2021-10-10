package com.dsckiet.mvvmtask.`interface`

import com.dsckiet.mvvmtask.model.Feeds
import retrofit2.http.GET

interface apirequest {

    @GET("/v2/top-headlines?country=in&apiKey=a2dcdde82b024544b87dcdfc364f3658")
    suspend fun getFeed(): Feeds


}