package com.blackstreet.github.models

import java.math.BigDecimal

data class RepositoryItemsModel(
    val photo: String,
    val name: String,
    val repository: String,
    val stars: BigDecimal,
    val forks: BigDecimal
)