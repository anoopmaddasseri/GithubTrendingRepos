package com.gojek.trendingrepos.viewmodels

import com.gojek.trendingrepos.BaseViewModelTest
import com.gojek.trendingrepos.domain.usecases.TrendingRepositoryUseCase
import com.gojek.trendingrepos.features.trendingrepo.TrendingRepositoryViewModel
import com.gojek.trendingrepos.mappers.toPresentation
import com.gojek.trendingrepos.utils.SampleData
import com.gojek.trendingrepos.utils.observeOnce
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
internal class TrendingRepositoryViewModelTest : BaseViewModelTest() {

    @Mock
    lateinit var trendingRepositoryUseCase: TrendingRepositoryUseCase
    private lateinit var trendingRepositoryViewModel: TrendingRepositoryViewModel

    @Before
    fun setup() {
        trendingRepositoryViewModel = TrendingRepositoryViewModel(trendingRepositoryUseCase)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun shouldReceiveSearchResults() {
        runBlockingTest {
            setMockAnswer()
            trendingRepositoryViewModel.executeTrendingRepositorySearch()
            trendingRepositoryViewModel.searchResultsTrendingRepositories.observeOnce {
                Truth.assertThat(it)
                    .isEqualTo(SampleData.repoSearchResults.map { repo -> repo.toPresentation() })
            }
        }
    }

    private suspend fun setMockAnswer() {
        given(trendingRepositoryUseCase(false)).willReturn(flow {
            emit(SampleData.repoSearchResults)
        })
    }
}