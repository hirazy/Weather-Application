package com.example.weatherapplication.data.dto

data class WeatherDayItem(
    var dt:Int,
    var dtTxt:String,
    var weatherIcon18H:String,
    var weatherDes18H:String,
    var weatherMain18H: String,
    var mainTemp18H:Double,
    var mainTempMin:Double,
    var mainTempMax:Double
)