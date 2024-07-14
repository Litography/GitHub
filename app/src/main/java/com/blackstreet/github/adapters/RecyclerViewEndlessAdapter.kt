package com.blackstreet.github.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blackstreet.github.databinding.RepositoryListItemBinding
import com.blackstreet.github.databinding.ShowLoadingBinding

class RecyclerViewEndlessAdapter(
    private val listData: ArrayList<String?>?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
            listData?.let {
                it[position]?.apply {
                    holder.bind(this)
                }
            }
        }

        if (holder is LoadingViewHolder) {
            listData?.let {
                it[position]?.apply {
                    holder.bind(this)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        listData?.let {
            if (it[position] == null) return SHOW_LOADING
        }

        return SHOW_ITEM
    }

    override fun getItemCount() = listData?.size ?: 0

    inner class ItemViewHolder(private val binding: RepositoryListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: String) {

        }
    }

    inner class LoadingViewHolder(private val binding: ShowLoadingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: String) {

        }
    }

    companion object {
        private const val SHOW_ITEM = 0
        private const val SHOW_LOADING = 1
    }
}