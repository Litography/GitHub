package com.blackstreet.github.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blackstreet.github.models.Items
import com.blackstreet.github.repositories.GitHubApis
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ResumeViewModel(
    private val repository: GitHubApis
) : ViewModel() {

    val responseRequest = MutableLiveData<ArrayList<Items>>()

    fun requestRepositories(numberPage: Int) {
        val disposable = repository.requestRepositoryOrdered(REQUEST_PARAMETERS_LANGUAGE, REQUEST_PARAMETERS_TYPE_ORDERED, numberPage)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    responseRequest.value = it.items
                    Log.e("responseRequest", it.toString())
                },
                { Log.e("errorRequest", it.message.toString()) }
            )
    }

    companion object{
        private const val REQUEST_PARAMETERS_LANGUAGE = "kotlin"
        private const val REQUEST_PARAMETERS_TYPE_ORDERED = "stars"
    }
}