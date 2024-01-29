package com.divyanshu.weatherapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.divyanshu.weatherapp.model.Weather
import com.divyanshu.weatherapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherRepository: WeatherRepository) : ViewModel() {
    private val CLASS_TAG = WeatherViewModel::class.qualifiedName

    private val response = MutableLiveData<Weather>()
    val weatherData: LiveData<Weather>
        get() = response

    init {
        getWeather()
    }

    private fun getWeather() = viewModelScope.launch {
        weatherRepository.getWeatherByLocationName().let {
            if (it.isSuccessful) {
                response.postValue(it.body())
            } else {
                Log.d(CLASS_TAG, "Something went wrong ${it.message()}")
            }
        }
    }
}