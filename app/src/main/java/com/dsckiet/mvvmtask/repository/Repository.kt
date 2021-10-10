package com.dsckiet.mvvmtask.repository

import androidx.lifecycle.MutableLiveData
import com.dsckiet.mvvmtask.api.RetrofitInstance
import com.dsckiet.mvvmtask.model.Feeds

class Repository{
    val showProgress = MutableLiveData<Boolean>()
    suspend fun getFeed(): Feeds {
        showProgress.value = true
        return RetrofitInstance.api.getFeed()
    }
}