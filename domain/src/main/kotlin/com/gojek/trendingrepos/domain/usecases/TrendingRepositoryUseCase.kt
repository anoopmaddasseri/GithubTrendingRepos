package com.gojek.trendingrepos.domain.usecases

import com.gojek.trendingrepos.domain.repository.ITrendingRepoSearchRepository
import javax.inject.Inject

class TrendingRepositoryUseCase @Inject constructor(
    private val searchRepository: ITrendingRepoSearchRepository
) {
    suspend operator fun invoke(forceRefresh: Boolean) =
        searchRepository.searchTrendingRepositories(forceRefresh)
}