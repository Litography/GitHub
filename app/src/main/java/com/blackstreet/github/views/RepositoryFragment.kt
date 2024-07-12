package com.blackstreet.github.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.blackstreet.github.adapters.ListRepositoryAdapter
import com.blackstreet.github.core.BaseFragment
import com.blackstreet.github.databinding.FragmentRepositoryBinding
import com.blackstreet.github.models.RepositoryItemsModel
import com.blackstreet.github.viewModels.RepositoryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepositoryFragment : BaseFragment() {

    private lateinit var binding: FragmentRepositoryBinding

//    private val viewModel: RepositoryViewModel by viewModels<RepositoryViewModel>()

    private val repositoryViewModel by viewModel<RepositoryViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRepositoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initViews() {
        val userData = listOf(
            RepositoryItemsModel("litography", ""),
            RepositoryItemsModel("blackstreet", "")
        )

        binding.recyclerViewRepositories.adapter = ListRepositoryAdapter(userData)
        binding.recyclerViewRepositories.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun initListeners() {}

    override fun initObservers() {
        repositoryViewModel.init()
    }
}