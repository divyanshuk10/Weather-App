package com.divyanshu.weatherapp.api

import com.divyanshu.weatherapp.model.Weather
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("weather")
    suspend fun getWeatherByLocationName(): Response<Weather>
}