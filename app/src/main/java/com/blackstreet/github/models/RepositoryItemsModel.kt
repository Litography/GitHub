package com.blackstreet.github.models

import com.google.gson.annotations.SerializedName

data class RepositoryItemsModel(
    @SerializedName("login")
    val user: String?,
    @SerializedName("avatar_url")
    val photo: String?
)