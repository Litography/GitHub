package com.blackstreet.github.repositories

import com.blackstreet.github.api.Services

class GitHubApis(private val services: Services) {

    fun requestRepositoryOrdered(language: String, type: String, numberPage: Int) =
        services.getRepositoryOrdered("language:$language", type, numberPage)
}