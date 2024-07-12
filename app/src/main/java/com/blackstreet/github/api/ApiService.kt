package com.blackstreet.github.api

import com.blackstreet.github.models.RepositoryItemsModel
import com.blackstreet.github.models.ResponseTest
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search/users")
    fun getRepositoryByUser(@Query("q") user: String): Call<ResponseTest>
}