package com.blackstreet.github.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blackstreet.github.adapters.RecyclerViewEndlessAdapter
import com.blackstreet.github.core.BaseFragment
import com.blackstreet.github.databinding.FragmentRepositoryBinding
import com.blackstreet.github.viewModels.ResumeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResumeFragment : BaseFragment() {

    private lateinit var binding: FragmentRepositoryBinding
    private lateinit var arrayList: ArrayList<String?>
    private lateinit var adapter: RecyclerViewEndlessAdapter

    private val resumeViewModel by viewModel<ResumeViewModel>()

    private var isLoading: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRepositoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initViews() {
        arrayList = arrayListOf("", "", "", "", "", "", "", "")
        adapter = RecyclerViewEndlessAdapter(arrayList)
        binding.recyclerViewRepositories.adapter = adapter
    }

    override fun initListeners() {
        with(binding) {
            recyclerViewRepositories.addOnScrollListener(object :
                RecyclerView.OnScrollListener() {

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    if (isLoading.not()) {
                        (recyclerViewRepositories.layoutManager as LinearLayoutManager).let {
                            if (it.findLastCompletelyVisibleItemPosition() == arrayList.size - 1) {
                                showMoreItems()
                                isLoading = true
                            }
                        }
                    }
                }
            })
        }
    }

    override fun initObservers() {
//        resumeViewModel.init()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun showMoreItems() {
        arrayList.add(null)
        adapter.notifyItemInserted(arrayList.size - 1)

        Handler(Looper.getMainLooper()).postDelayed({
            var scrollPosition = arrayList.size
            val nextLimit = arrayList.size + 5

            arrayList.removeAt(scrollPosition - 1)
            adapter.notifyItemRemoved(scrollPosition)

            while (scrollPosition - 1 < nextLimit) {
                arrayList.add("")
                scrollPosition++
            }

            adapter.notifyDataSetChanged()
            isLoading = false
        }, 2000)
    }
}