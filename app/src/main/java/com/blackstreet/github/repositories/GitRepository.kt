package com.blackstreet.github.repositories

import com.blackstreet.github.api.ApiService

class GitRepository(private val apiService: ApiService) {

    fun requestUserGitRepository(user: String) = apiService.getRepositoryByUser(user)
}