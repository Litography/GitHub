package com.blackstreet.github.api

import com.blackstreet.github.models.ClassifiedRepository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Services {

    @GET("search/repositories")
    fun getRepositoryOrdered(@Query("q") language: String, @Query("sort") type: String, @Query("page") numberPage: Int): Call<ClassifiedRepository>
}