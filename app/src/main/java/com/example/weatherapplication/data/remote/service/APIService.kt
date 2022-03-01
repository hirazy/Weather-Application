package com.example.weatherapplication.data.remote.service

import Weather5DayData
import com.example.weatherapplication.data.dto.currentweather.CurrentWeatherResponse
import com.example.weatherapplication.data.dto.daysweather.MultipleDaysWeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    /**
     * Get current weather of city
     *
     * @param q     String name of city
     * @param units String units of response
     * @param lang  String language of response
     * @param appId String api key
     * @return instance of {@link CurrentWeatherResponse}
     */
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("lat") lat: String,
        @Query("lon") long: String,
        @Query("appid") apiKey: String,
    ): Response<CurrentWeatherResponse>


    /**
     * Get five days weather forecast.
     *
     * @param q     String name of city
     * @param units String units of response
     * @param lang  String language of response
     * @param appId String api key
     * @return instance of {@link FiveDayResponse}
     */
    @GET("forecast")
    suspend fun getFiveDaysWeather(
        @Query("lat") lat: String,
        @Query("lon") long: String,
        @Query("appid") apiKey: String
    ): Response<Weather5DayData>

    /**
     * Get multiple days weather
     *
     * @param q     String name of city
     * @param units String units of response
     * @param lang  String language of response
     * @param appId String api key
     * @return instance of {@link MultipleDaysWeatherResponse}
     */
    @GET("forecast/daily")
    suspend fun getMultipleDaysWeather(
        @Query("q") q: String,
        @Query("units") units: String,
        @Query("lang") lang: String,
        @Query("cnt") dayCount: Int,
        @Query("appid") appId: String
    ): Response<MultipleDaysWeatherResponse>

}