package com.blackstreet.github.viewModels

import androidx.lifecycle.ViewModel
import com.blackstreet.github.models.ResponseTest
import com.blackstreet.github.repositories.GitRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryViewModel(
    private val repository: GitRepository
) : ViewModel() {

    fun init() {
        repository.requestUserGitRepository("litography")
            .enqueue(object : Callback<ResponseTest> {
                override fun onResponse(
                    call: Call<ResponseTest>,
                    response: Response<ResponseTest>
                ) {
                    if (response.isSuccessful) {
                        response.body()
                    }
                }

                override fun onFailure(call: Call<ResponseTest>, t: Throwable) {

                }

            })
    }
}