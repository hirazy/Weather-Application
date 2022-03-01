package com.example.weatherapplication.data.dto.fivedayweather

import com.example.weatherapplication.base.OBase
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rain(
    @SerializedName("3h")
    val jsonMember3h: Double

): OBase()