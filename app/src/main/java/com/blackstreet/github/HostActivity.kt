package com.blackstreet.github

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.navigation.findNavController
import com.blackstreet.github.core.BaseActivity
import com.blackstreet.github.databinding.ActivityHostBinding

class HostActivity : BaseActivity() {

    private lateinit var binding: ActivityHostBinding

    private val onBackPressed: OnBackPressedCallback by lazy {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (!findNavController(R.id.fragmentContainerView).popBackStack()) {
                    finish()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBackPressedDispatcher.addCallback(this, onBackPressed)
        binding = ActivityHostBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun initViews() {}

    override fun initListeners() {}

    override fun initObservers() {}
}