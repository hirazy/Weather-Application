package com.example.weatherapplication.data.dto.daysweather

import com.example.weatherapplication.base.OBase
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Temp(
    @SerializedName("min")
    val min: Double,

    @SerializedName("max")
    val max: Double,

    @SerializedName("eve")
    val eve: Double,

    @SerializedName("night")
    val night: Double,

    @SerializedName("day")
    val day: Double,

    @SerializedName("morn")
    val morn: Double
) : OBase()