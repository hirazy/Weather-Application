package com.example.weatherapplication.data.dto.currentweather

import com.example.weatherapplication.base.OBase
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Main(

    @SerializedName("temp")
    val temp: Double,

    @SerializedName("temp_min")
    val tempMin: Double,

    @SerializedName("grnd_level")
    val grndLevel: Double,

    @SerializedName("humidity")
    val humidity: Int,

    @SerializedName("pressure")
    val pressure: Double,

    @SerializedName("sea_level")
    val seaLevel: Double,

    @SerializedName("temp_max")
    val tempMax: Double
): OBase()