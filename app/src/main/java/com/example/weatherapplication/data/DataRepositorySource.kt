package com.example.weatherapplication.data

import Weather5DayData
import com.example.weatherapplication.data.dto.WeatherInfo
import kotlinx.coroutines.flow.Flow

interface DataRepositorySource {

    suspend fun requestGetWeather(lat: String, long: String, appId: String): Flow<Resource<WeatherInfo>>

    suspend fun requestGet5DaysWeather(lat: String, long: String, appId: String): Flow<Resource<Weather5DayData>>
}