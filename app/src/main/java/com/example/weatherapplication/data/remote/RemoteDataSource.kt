package com.example.weatherapplication.data.remote

import Weather5DayData
import com.example.weatherapplication.data.Resource
import com.example.weatherapplication.data.dto.currentweather.CurrentWeatherResponse

interface RemoteDataSource {
    /**
     * Get Weather
     */
    suspend fun requestGetWeather(lat: String,
                                  long: String,
                                  appId: String): Resource<CurrentWeatherResponse>

    suspend fun requestGet5DayWeather(lat: String,
                                      long: String,
                                      appId: String): Resource<Weather5DayData>
}