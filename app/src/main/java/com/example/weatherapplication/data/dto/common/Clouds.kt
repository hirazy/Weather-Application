package com.example.weatherapplication.data.dto.common

import com.example.weatherapplication.base.OBase
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Clouds(
    @SerializedName("all") val all: Int
): OBase()