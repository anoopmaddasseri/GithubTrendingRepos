package com.mvvmclean.trendingrepos.data.repository

import com.mvvmclean.trendingrepos.domain.models.TrendingRepo
import com.mvvmclean.trendingrepos.domain.repository.ITrendingRepoSearchRepository
import com.mvvmclean.trendingrepos.data.mappers.toDomain
import com.mvvmclean.trendingrepos.data.source.TrendingRepoSearchDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Co-ordinates data sources exposing search results
 */
class TrendingRepoSearchRepository @Inject constructor(
    private val trendingRepoSearchDataSource: TrendingRepoSearchDataSource
) : ITrendingRepoSearchRepository {

    override suspend fun searchTrendingRepositories(forceRefresh: Boolean): Flow<List<TrendingRepo>> {
        return trendingRepoSearchDataSource.query(forceRefresh)
            .map { it.map { results -> results.toDomain() } }
    }

}