package com.gojek.trendingrepos.features.trendingrepo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gojek.trendingrepos.databinding.ItemTrendingRepoBinding
import com.gojek.trendingrepos.models.TrendingRepositoryUiModel
import com.gojek.trendingrepos.util.circleCrop
import com.gojek.trendingrepos.util.hide
import com.gojek.trendingrepos.util.setDrawableBackgroundColor
import com.gojek.trendingrepos.util.show

class TrendingRepoSearchResultAdapter(val onClick: (TrendingRepositoryUiModel) -> Unit) :
    ListAdapter<TrendingRepositoryUiModel, TrendingRepoSearchResultAdapter.TrendingRepoViewHolder>(
        TrendingRepoDiffUtil
    ) {

    private var lastSelectedPosition: Int = RecyclerView.NO_POSITION

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
            populateData(modelRepository)
            binding.root.setOnClickListener {
                expandCollapse(modelRepository, position)
            }
        }

        private fun populateData(modelRepository: TrendingRepositoryUiModel) {
            binding.apply {
                modelRepository.let { it ->
                    it.languageColor?.let { binding.tvRepoLang.setDrawableBackgroundColor(it) }
                    it.avatar.let { binding.ivUserAvatar.circleCrop(it) }
                    if (it.expand) {
                        groupExpansion.show()
                    } else {
                        groupExpansion.hide()
                    }
                }
            }
        }

        private fun expandCollapse(
            modelRepository: TrendingRepositoryUiModel,
            position: Int
        ) {
            //Expand on clicking same item in collapsed state
            if (lastSelectedPosition == position && !modelRepository.expand) {
                modelRepository.expand = true
                notifyItemChanged(position)
                return
            }
            //Collapse previous item
            if (lastSelectedPosition != RecyclerView.NO_POSITION) {
                getItem(lastSelectedPosition).expand = false
                notifyItemChanged(lastSelectedPosition)
            }
            //Return when click on already expanded item
            if (lastSelectedPosition == position) {
                return
            }
            //Expand clicked  item
            modelRepository.let {
                it.expand = !it.expand
            }
            notifyItemChanged(position)
            lastSelectedPosition = position
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