package com.example.weatherapplication.data.dto.common

import com.example.weatherapplication.base.OBase
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherItem(
    @SerializedName("icon")
    val icon: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("main")
    val main: String,

    @SerializedName("id")
    val id: String
) : OBase()