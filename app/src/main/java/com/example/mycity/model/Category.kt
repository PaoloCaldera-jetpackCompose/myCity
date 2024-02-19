package com.example.mycity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    val id: Int,
    @StringRes val name: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)