package com.blackstreet.github.core

import android.app.Application
import com.blackstreet.github.di.Modules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BaseApplication)
            androidLogger()
            with(Modules()) {
                modules(network, repository, viewModel)
            }
        }
    }
}