package com.example.weatherapplication.data.dto.fivedayweather

import City5Day
import WeatherDetail
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.weatherapplication.base.OBase
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Weather5DayData")
data class FiveDayResponse(
    @SerializedName("cod") val cod: String,
    @SerializedName("message") val message: Int,
    @SerializedName("cnt") val cnt: Int,
    @SerializedName("list") val listDataDetail: List<WeatherDetail>,
    @SerializedName("city") val city: City5Day,
    @PrimaryKey(autoGenerate = false) var id: Int? = null
): OBase()