package com.example.weatherapplication.data

import Weather5DayData
import com.example.weatherapplication.data.dto.currentweather.CurrentWeatherResponse
import com.example.weatherapplication.data.local.LocalData
import com.example.weatherapplication.data.remote.RemoteData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DataRepository @Inject constructor(
    var remoteDataRepository: RemoteData,
    var localDataRepository: LocalData,
    var context: CoroutineContext
) : DataRepositorySource {
    override suspend fun requestGetWeather(
        lat: String,
        long: String,
        appId: String
    ): Flow<Resource<CurrentWeatherResponse>> {
        return flow {
            emit(remoteDataRepository.requestGetWeather(lat, long, appId))
        }.flowOn(context)
    }

    override suspend fun requestGet5DaysWeather(
        lat: String,
        long: String,
        appId: String
    ): Flow<Resource<Weather5DayData>> {
        return flow {
            emit(remoteDataRepository.requestGet5DayWeather(lat, long, appId))
        }.flowOn(context)
    }
}