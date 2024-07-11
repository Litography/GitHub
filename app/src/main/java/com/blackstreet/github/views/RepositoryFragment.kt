package com.blackstreet.github.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.blackstreet.github.core.BaseFragment
import com.blackstreet.github.databinding.FragmentRepositoryBinding
import com.blackstreet.github.viewModels.RepositoryViewModel

class RepositoryFragment : BaseFragment() {

    private lateinit var binding: FragmentRepositoryBinding

    private val viewModel: RepositoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRepositoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initViews() {}

    override fun initListeners() {}

    override fun initObservers() {}
}