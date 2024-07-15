package com.blackstreet.github.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.blackstreet.github.R
import com.blackstreet.github.core.BaseFragment
import com.blackstreet.github.databinding.FragmentDetailsBinding
import com.blackstreet.github.viewModels.DetailsViewModel
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : BaseFragment() {

    private lateinit var binding: FragmentDetailsBinding

    private val viewModel by viewModel<DetailsViewModel>()

    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initViews() {
        with(binding) {
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back)

            Glide.with(requireContext())
                .load(args.details.owner.avatarUrl)
                .error(R.drawable.ic_image_not_found)
                .into(photo)

            with(args) {
                userInfo.text = details.owner.login
                repositoryInfo.text = details.name
                starsInfo.text = details.stargazersCount.toString()
                forksInfo.text = details.forks.toString()
            }
        }
    }

    override fun initListeners() {
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    override fun initObservers() {

    }
}