package com.example.weatherapplication.error


interface ErrorUseCase {
    fun getError(errorCode: Int): Error
}
