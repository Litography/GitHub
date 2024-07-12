package com.blackstreet.github

import android.os.Bundle
import com.blackstreet.github.core.BaseActivity
import com.blackstreet.github.databinding.ActivityMainBinding

class HostActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun initViews() {}

    override fun initListeners() {}

    override fun initObservers() {}
}