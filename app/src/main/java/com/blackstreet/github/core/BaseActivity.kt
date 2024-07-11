package com.blackstreet.github.core

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(), BaseEvents {

    override fun onStart() {
        super.onStart()
        initViews()
        initListeners()
        initObservers()
    }
}