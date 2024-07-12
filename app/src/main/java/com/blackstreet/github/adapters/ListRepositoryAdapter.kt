package com.blackstreet.github.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blackstreet.github.databinding.RepositoryListItemBinding
import com.blackstreet.github.models.RepositoryItemsModel

class ListRepositoryAdapter(
    private val data: List<RepositoryItemsModel>
) : RecyclerView.Adapter<ListRepositoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RepositoryListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            binding.textViewUserName.text = data[position].user
        }
    }

    override fun getItemCount() = data.size

    inner class ViewHolder(val binding: RepositoryListItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}