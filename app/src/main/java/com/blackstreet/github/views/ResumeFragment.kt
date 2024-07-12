package com.blackstreet.github.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.blackstreet.github.core.BaseFragment
import com.blackstreet.github.databinding.FragmentRepositoryBinding
import com.blackstreet.github.viewModels.ResumeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResumeFragment : BaseFragment() {

    private lateinit var binding: FragmentRepositoryBinding

    private val resumeViewModel by viewModel<ResumeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRepositoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initViews() {
//        val userData = listOf(
//            RepositoryItemsModel("litography", ""),
//            RepositoryItemsModel("blackstreet", "")
//        )
//
//        binding.recyclerViewRepositories.adapter = ListRepositoryAdapter(userData)
//        binding.recyclerViewRepositories.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun initListeners() {}

    override fun initObservers() {
        resumeViewModel.init()
    }
}