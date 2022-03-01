package com.example.weatherapplication.data.dto.daysweather

import com.example.weatherapplication.base.OBase
import com.example.weatherapplication.data.dto.common.Coord
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class City(
    @SerializedName("country")
    val country: String,

    @SerializedName("coord")
    val coord: Coord,

    @SerializedName("name")
    val name: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("population")
    val population: Int
) : OBase()