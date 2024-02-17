package com.example.mycity.model

import androidx.annotation.StringRes

data class Entry(
    val id: Int,
    @StringRes val name: Int,
    @StringRes val rate: Int,
    @StringRes val address: Int,
    @StringRes val description: Int
)
