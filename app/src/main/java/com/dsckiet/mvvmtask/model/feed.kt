package com.dsckiet.mvvmtask.model

data class feed(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)