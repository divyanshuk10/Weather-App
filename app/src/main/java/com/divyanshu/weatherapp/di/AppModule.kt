package com.divyanshu.weatherapp.di

import android.os.Build
import com.divyanshu.weatherapp.api.ApiService
import com.divyanshu.weatherapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesBaseURL(): String {
        val buildType = Build.TYPE
        if (buildType != null && buildType.contains("debug", ignoreCase = true)) {
            return Constants.BASE_URL
        }
        return Constants.BASE_URL
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(baseUrl: String): ApiService = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)
}