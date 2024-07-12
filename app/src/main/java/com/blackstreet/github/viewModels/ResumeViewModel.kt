package com.blackstreet.github.viewModels

import androidx.lifecycle.ViewModel
import com.blackstreet.github.models.ClassifiedRepository
import com.blackstreet.github.repositories.GitHubApis
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResumeViewModel(
    private val repository: GitHubApis
) : ViewModel() {

    fun init() {
        repository.requestRepositoryOrdered("kotlin", "stars", 1)
            .enqueue(object : Callback<ClassifiedRepository> {
                override fun onResponse(
                    call: Call<ClassifiedRepository>,
                    response: Response<ClassifiedRepository>
                ) {
                    if (response.isSuccessful) {
                        response.body()
                    }
                }

                override fun onFailure(call: Call<ClassifiedRepository>, t: Throwable) {

                }
            })
    }
}