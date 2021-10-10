package com.dsckiet.mvvmtask.Viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dsckiet.mvvmtask.model.Feeds
import com.dsckiet.mvvmtask.repository.Repository
import kotlinx.coroutines.launch


class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Feeds> = MutableLiveData()
    lateinit var showProgress: LiveData<Boolean>
    init {
        showProgress = repository.showProgress
    }
    fun getFeed(context: Context){
        viewModelScope.launch {
            val response: Feeds = repository.getFeed()
            myResponse.value = response
        }
    }

}