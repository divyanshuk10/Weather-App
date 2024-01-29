package com.divyanshu.weatherapp.repository

import com.divyanshu.weatherapp.api.ApiService
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getWeatherByLocationName() = apiService.getWeatherByLocationName()
}