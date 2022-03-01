package com.example.weatherapplication.data.dto.daysweather

import com.example.weatherapplication.base.OBase
import com.example.weatherapplication.data.dto.common.WeatherItem
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListItem(
    @SerializedName("dt")
    val dt: Int,

    @SerializedName("temp")
    val temp: Temp,

    @SerializedName("deg")
    val deg: Int,

    @SerializedName("weather")
    val weather: List<WeatherItem>,

    @SerializedName("humidity")
    val humidity : Int,

    @SerializedName("pressure")
    val pressure: Double,

    @SerializedName("clouds")
    val clouds: Int,

    @SerializedName("speed")
    val speed: Double,

    @SerializedName("rain")
    val rain: Double
): OBase()