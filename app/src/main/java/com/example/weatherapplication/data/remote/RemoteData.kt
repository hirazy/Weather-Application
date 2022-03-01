package com.example.weatherapplication.data.remote

import Weather5DayData
import com.example.weatherapplication.data.Resource
import com.example.weatherapplication.data.dto.currentweather.CurrentWeatherResponse
import com.example.weatherapplication.data.error.NETWORK_ERROR
import com.example.weatherapplication.data.error.NO_INTERNET_CONNECTION
import com.example.weatherapplication.data.remote.service.APIService
import com.example.weatherapplication.utils.NetworkConnectivity
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteData @Inject constructor(
    private val serviceGenerator: ServiceGenerator,
    private val networkConnectivity: NetworkConnectivity
) : RemoteDataSource {

    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
        if (!networkConnectivity.isConnected()) {
            return NO_INTERNET_CONNECTION
        }
        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {
                response.body()
            } else {
                responseCode
            }
        } catch (e: IOException) {
            NETWORK_ERROR
        }
    }

    /**
     * @param lat
     * @param long
     * @param appId
     * @exception NO_INTERNET_CONNECTION
     * @throws IOException
     * @return Resource<WeatherInfo>
     */
    override suspend fun requestGetWeather(
        lat: String,
        long: String,
        appId: String
    ): Resource<CurrentWeatherResponse> {
        val service = serviceGenerator.createService(APIService::class.java)

        return when (val response = processCall { service.getCurrentWeather(lat, long, appId) }) {
            is CurrentWeatherResponse -> {
                Resource.Success(data = response as CurrentWeatherResponse)
            }
            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }
    }

    override suspend fun requestGet5DayWeather(
        lat: String,
        long: String,
        appId: String
    ): Resource<Weather5DayData> {
        val service = serviceGenerator.createService(APIService::class.java)

        return when (val response =
            processCall { service.getFiveDaysWeather(lat = lat, long = long, appId) }) {
            is Weather5DayData -> {
                Resource.Success(data = response)
            }
            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }
    }

}