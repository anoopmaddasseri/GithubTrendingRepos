package com.gojek.trendingrepos.features.trendingrepo

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gojek.trendingrepos.commons.Loading
import com.gojek.trendingrepos.commons.Success
import com.gojek.trendingrepos.commons.UiStateViewModel
import com.gojek.trendingrepos.domain.usecases.TrendingRepositoryUseCase
import com.gojek.trendingrepos.mappers.toPresentation
import com.gojek.trendingrepos.models.TrendingRepositoryUiModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class TrendingRepositoryViewModel @Inject constructor(
    private val trendingRepositoryUseCase: TrendingRepositoryUseCase
) : UiStateViewModel() {

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

    override fun onDestroy(lifecycleOwner: LifecycleOwner) {
    }
}