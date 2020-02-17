package com.gojek.trendingrepos.features.trendingrepo

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gojek.trendingrepos.commons.Loading
import com.gojek.trendingrepos.commons.Success
import com.gojek.trendingrepos.commons.UiState
import com.gojek.trendingrepos.commons.UiStateViewModel
import com.gojek.trendingrepos.domain.usecases.TrendingRepositoryUseCase
import com.gojek.trendingrepos.mappers.toPresentation
import com.gojek.trendingrepos.models.SortType
import com.gojek.trendingrepos.models.TrendingRepositoryUiModel
import kotlinx.coroutines.*

import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class TrendingRepositoryViewModel @Inject constructor(
    private val trendingRepositoryUseCase: TrendingRepositoryUseCase
) : UiStateViewModel() {

    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)
    private var searchJob: Job? = null

    val searchResultsTrendingRepositories: LiveData<List<TrendingRepositoryUiModel>>
        get() = _searchResultsTrendingRepository

    private var _searchResultsTrendingRepository: MutableLiveData<List<TrendingRepositoryUiModel>> =
        MutableLiveData()

    fun executeTrendingRepositorySearch() {
        _uiState.value = Loading
        viewModelScope.launch(handler) {
            trendingRepositoryUseCase().collect { results ->
                _searchResultsTrendingRepository.value = results.map { it.toPresentation() }
            }
            _uiState.value = Success
        }
    }

    fun sortTrendingRepoResult(sortType: SortType) {
        if (_uiState.value is Success) {
            val list = _searchResultsTrendingRepository.value
            when (sortType) {
                is SortType.SortByName -> {
                    sortByNames(list)
                }
                is SortType.SortByStars -> {
                    sortByStars(list)
                }
            }
        }
    }

    private fun sortByNames(trendingRepo: List<TrendingRepositoryUiModel>?) {
        _uiState.value = Loading
        searchJob?.cancel()
        searchJob = coroutineScope.launch {
            _searchResultsTrendingRepository.value = trendingRepo?.sortedBy { it.name }
            delay(1000)
            _uiState.value = Success
        }
    }

    private fun sortByStars(trendingRepo: List<TrendingRepositoryUiModel>?) {
        _uiState.value = Loading
        searchJob?.cancel()
        searchJob = coroutineScope.launch {
            _searchResultsTrendingRepository.value = trendingRepo?.sortedByDescending { it.stars }
            delay(1000)
            _uiState.value = Success
        }
    }

    override fun onDestroy(lifecycleOwner: LifecycleOwner) {
        searchJob?.cancel()
    }
}