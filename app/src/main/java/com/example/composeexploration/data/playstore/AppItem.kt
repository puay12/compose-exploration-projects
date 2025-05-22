package com.example.composeexploration.data.playstore

data class AppItem(
    val id: Int,
    val imageString: String,
    val name: String,
    val company: String,
    val rating: Double,
    val categoryList: List<String>,
    val appSize: Long
)
