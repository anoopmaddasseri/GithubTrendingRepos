package com.gojek.trendingrepos.features.trendingrepo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gojek.trendingrepos.R
import com.gojek.trendingrepos.base.BaseActivity
import com.gojek.trendingrepos.commons.Error
import com.gojek.trendingrepos.commons.Loading
import com.gojek.trendingrepos.commons.Success
import com.gojek.trendingrepos.util.hide
import com.gojek.trendingrepos.util.show
import kotlinx.android.synthetic.main.activity_trending_repository.*
import kotlinx.android.synthetic.main.layout_status_loading.*
import javax.inject.Inject

class TrendingRepoSearchActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val trendingRepositoryViewModel: TrendingRepositoryViewModel by viewModels { viewModelFactory }

    private val trendingRepoSearchResultAdapter: TrendingRepoSearchResultAdapter by lazy {
        TrendingRepoSearchResultAdapter {
        }
    }

    override fun initComponents(savedInstanceState: Bundle?) {
        observeUiState()
        observeSearchResults()
        fetchTrendingRepositories()
    }

    override fun getLayoutId() = R.layout.activity_trending_repository

    private fun observeUiState() {
        trendingRepositoryViewModel.uiState.observe(this, Observer {
            when (it) {
                is Loading -> displayLoadingState()
                is Success -> hideLoadingState()
                is Error -> displayErrorState(it.error)
            }
        })
    }

    private fun observeSearchResults() {
        trendingRepositoryViewModel.searchResultsTrendingRepositories.observe(this, Observer {
        })
    }

    private fun fetchTrendingRepositories() {
        trendingRepositoryViewModel.executeTrendingRepositorySearch()
    }

    private fun displayLoadingState() {
        rvRepository.hide()
        containerShimmer.show()
        containerShimmer.showShimmer(true)
    }

    private fun hideLoadingState() {
        rvRepository.show()
        containerShimmer.hide()
        containerShimmer.stopShimmer()
    }

    private fun displayNoSearchResults() {
    }

    private fun displayErrorState(error: Throwable) {
    }

}
