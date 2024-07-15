package com.blackstreet.github.di

import com.blackstreet.github.api.Provides
import com.blackstreet.github.repositories.GitHubApis
import com.blackstreet.github.viewModels.DetailsViewModel
import com.blackstreet.github.viewModels.ResumeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class Modules {

    val network = module {
        with(Provides()) {
            single { provideHttpClient() }
            single { provideConverterFactory() }
            single { provideRetrofit(get(), get()) }
            single { provideService(get()) }
        }
    }

    val repository = module {
        single { GitHubApis(get()) }
    }

    val viewModel = module {
        viewModel { ResumeViewModel(get()) }
        viewModel { DetailsViewModel() }
    }
}