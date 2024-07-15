package com.blackstreet.github.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blackstreet.github.R
import com.blackstreet.github.adapters.RecyclerViewEndlessAdapter
import com.blackstreet.github.core.BaseFragment
import com.blackstreet.github.databinding.FragmentRepositoryBinding
import com.blackstreet.github.models.Items
import com.blackstreet.github.viewModels.ResumeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResumeFragment : BaseFragment() {

    private lateinit var binding: FragmentRepositoryBinding
    private lateinit var adapter: RecyclerViewEndlessAdapter

    private val viewModel by viewModel<ResumeViewModel>()

    private var arrayListItems: ArrayList<Items?> = arrayListOf()
    private var isLoading: Boolean = false
    private var indexPage: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRepositoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initViews() {
        binding.toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        adapter = RecyclerViewEndlessAdapter(arrayListItems) {
            findNavController().navigate(ResumeFragmentDirections.redirectToDetailsFragment(it))
        }
        binding.recyclerViewRepositories.adapter = adapter
        updateMoreListItems()
    }

    override fun initListeners() {
        with(binding.recyclerViewRepositories) {
            addOnScrollListener(object :
                RecyclerView.OnScrollListener() {

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    if (isLoading.not()) {
                        (layoutManager as LinearLayoutManager).apply {
                            findLastCompletelyVisibleItemPosition().let {
                                if (it > RECYCLER_VIEW_EMPTY && it == arrayListItems.size - 1) {
                                    isLoading = true
                                    updateMoreListItems()
                                }
                            }
                        }
                    }
                }
            })
        }

        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun initObservers() {
        viewModel.responseRequest.removeObservers(this)
        viewModel.responseRequest.observe(this) { response ->
            arrayListItems.removeAt(arrayListItems.size - 1)
            adapter.notifyItemRemoved(arrayListItems.size)

            response.forEach {
                arrayListItems.add(it)
            }

            adapter.notifyDataSetChanged()
            isLoading = false
        }
    }

    private fun updateMoreListItems() {
        with(arrayListItems) {
            add(null)
            adapter.notifyItemInserted(size - 1)
            viewModel.requestRepositories(++indexPage)
        }
    }

    companion object {
        private const val RECYCLER_VIEW_EMPTY = 0
    }
}