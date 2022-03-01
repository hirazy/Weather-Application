package com.example.weatherapplication.data.dto.daysweather

import com.example.weatherapplication.base.OBase
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MultipleDaysWeatherResponse(

    @SerializedName("city")
    val city: City,

    @SerializedName("cnt")
    val cnt: Int,

    @SerializedName("cod")
    val cod: String,

    @SerializedName("message")
    val message: Double,

    @SerializedName("list")
    val list: List<ListItem>
): OBase()