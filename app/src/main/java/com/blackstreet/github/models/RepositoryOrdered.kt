package com.blackstreet.github.models

import com.google.gson.annotations.SerializedName

data class ClassifiedRepository(
    @SerializedName("items")
    val items: List<Items>
)

data class Items(
    @SerializedName("name")
    val name: String,
    @SerializedName("owner")
    val owner: Owner,
    @SerializedName("stargazers_count")
    val stargazersCount: Int,
    @SerializedName("forks")
    val forks: Int
)

data class Owner(
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String
)