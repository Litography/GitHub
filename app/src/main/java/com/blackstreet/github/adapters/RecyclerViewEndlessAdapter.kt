package com.blackstreet.github.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blackstreet.github.R
import com.blackstreet.github.databinding.RepositoryListItemBinding
import com.blackstreet.github.databinding.ShowLoadingBinding
import com.blackstreet.github.models.Items
import com.bumptech.glide.Glide

class RecyclerViewEndlessAdapter(
    private val listRepositoriesItems: ArrayList<Items?>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        listRepositoriesItems.let {
            if (it[position] == null) return SHOW_LOADING
        }

        return SHOW_ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == SHOW_ITEM) ItemViewHolder(
            RepositoryListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        else LoadingViewHolder(
            ShowLoadingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            listRepositoriesItems.let {
                it[position]?.apply {
                    holder.bind(this)
                }
            }
        }
    }

    override fun getItemCount() = listRepositoriesItems.size

    inner class ItemViewHolder(private val binding: RepositoryListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(items: Items) {
            with(binding) {
                Glide.with(root.context)
                    .load(items.owner.avatarUrl)
                    .error(R.drawable.ic_image_not_found)
                    .into(photo)

                user.text = items.owner.login
                repository.text = items.name
            }
        }
    }

    inner class LoadingViewHolder(binding: ShowLoadingBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        private const val SHOW_ITEM = 0
        private const val SHOW_LOADING = 1
    }
}