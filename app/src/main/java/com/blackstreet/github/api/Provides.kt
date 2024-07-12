package com.blackstreet.github.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Provides {

    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    fun provideConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()

    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_API_GIT_HUB)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    fun provideService(retrofit: Retrofit): Services =
        retrofit.create(Services::class.java)

    companion object {
        private const val BASE_URL_API_GIT_HUB = "https://api.github.com/"
    }
}