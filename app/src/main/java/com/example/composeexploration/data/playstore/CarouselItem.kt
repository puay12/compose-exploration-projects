package com.example.composeexploration.data.playstore

import androidx.annotation.DrawableRes

data class CarouselItem(
    val id: Int,
    @DrawableRes val imageResId: Int,
    val title: String,
    val contentDescription: String,
    val isAppItem: Boolean = false,
    val appButtonAction: () -> Unit = {},
    @DrawableRes val appLogoResId: Int = 0,
    val appName: String = "",
    val appCompany: String = "",
    val appAgeRestriction: String = "",
    val appRating: String = "",
    val description: String = "",
    val additionalDesc: String = "",
)
