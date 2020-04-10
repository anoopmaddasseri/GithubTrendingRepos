package com.mvvmclean.trendingrepos.domain.repository

import com.mvvmclean.trendingrepos.domain.models.TrendingRepo
import kotlinx.coroutines.flow.Flow

interface ITrendingRepoSearchRepository {
    suspend fun searchTrendingRepositories(forceRefresh: Boolean): Flow<List<TrendingRepo>>
}