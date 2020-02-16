package com.gojek.trendingrepos.features.trendingrepo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gojek.trendingrepos.databinding.ItemTrendingRepoBinding
import com.gojek.trendingrepos.models.TrendingRepositoryUiModel


class TrendingRepoSearchResultAdapter(val onClick: (TrendingRepositoryUiModel) -> Unit) :
    ListAdapter<TrendingRepositoryUiModel, TrendingRepoSearchResultAdapter.TrendingRepoViewHolder>(
        TrendingRepoDiffUtil
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingRepoViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        return TrendingRepoViewHolder(ItemTrendingRepoBinding.inflate(inflater))
    }

    override fun onBindViewHolder(holder: TrendingRepoViewHolder, position: Int): Unit =
        getItem(position).let { holder.bind(it, holder.layoutPosition) }

    inner class TrendingRepoViewHolder(private val binding: ItemTrendingRepoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(modelRepository: TrendingRepositoryUiModel, position: Int) {
            binding.searchedTrendingRepo = modelRepository
            binding.executePendingBindings()
        }

    }

    companion object {
        val TrendingRepoDiffUtil =
            object : DiffUtil.ItemCallback<TrendingRepositoryUiModel>() {
                override fun areItemsTheSame(
                    oldItem: TrendingRepositoryUiModel,
                    newItem: TrendingRepositoryUiModel
                ): Boolean = oldItem.url == newItem.url

                override fun areContentsTheSame(
                    oldItem: TrendingRepositoryUiModel,
                    newItem: TrendingRepositoryUiModel
                ): Boolean = oldItem == newItem

            }
    }
}