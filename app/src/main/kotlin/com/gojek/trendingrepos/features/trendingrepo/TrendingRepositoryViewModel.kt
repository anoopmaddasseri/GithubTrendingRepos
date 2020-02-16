package com.gojek.trendingrepos.features.trendingrepo

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gojek.trendingrepos.commons.UiStateViewModel
import com.gojek.trendingrepos.domain.usecases.TrendingRepositoryUseCase
import com.gojek.trendingrepos.models.TrendingRepositoryUiModel
import javax.inject.Inject

class TrendingRepositoryViewModel @Inject constructor(
    private val trendingRepositoryUseCase: TrendingRepositoryUseCase
) : UiStateViewModel() {

    val searchResultsTrendingRepositories: LiveData<List<TrendingRepositoryUiModel>>
        get() = _searchResultsTrendingRepository

    private var _searchResultsTrendingRepository: MutableLiveData<List<TrendingRepositoryUiModel>> =
        MutableLiveData()


    override fun onDestroy(lifecycleOwner: LifecycleOwner) {
    }
}