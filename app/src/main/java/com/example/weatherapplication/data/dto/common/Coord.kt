package com.example.weatherapplication.data.dto.common

import com.example.weatherapplication.base.OBase
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coord(
    @SerializedName("lon") val lon: Double,
    @SerializedName("lat") val lat: Double
): OBase()