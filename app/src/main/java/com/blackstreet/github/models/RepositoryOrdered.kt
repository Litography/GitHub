package com.blackstreet.github.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ClassifiedRepository(
    @SerializedName("items")
    val items: ArrayList<Items>
) : Parcelable

@Parcelize
data class Items(
    @SerializedName("name")
    val name: String,
    @SerializedName("owner")
    val owner: Owner,
    @SerializedName("stargazers_count")
    val stargazersCount: Int,
    @SerializedName("forks")
    val forks: Int
) : Parcelable

@Parcelize
data class Owner(
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String
) : Parcelable