package com.sky.picsum.model

data class PicsumResponseItem(
    val author: String,
    val download_url: String,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)