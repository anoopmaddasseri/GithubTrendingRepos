package com.mvvmclean.trendingrepos.domain.usecases

import com.mvvmclean.trendingrepos.domain.repository.ITrendingRepoSearchRepository
import javax.inject.Inject

class TrendingRepositoryUseCase @Inject constructor(
    private val searchRepository: ITrendingRepoSearchRepository
) {
    suspend operator fun invoke(forceRefresh: Boolean) =
        searchRepository.searchTrendingRepositories(forceRefresh)
}