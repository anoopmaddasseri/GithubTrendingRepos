package com.gojek.trendingrepos.data.repository

import com.gojek.trendingrepos.domain.models.TrendingRepo
import com.gojek.trendingrepos.domain.repository.ITrendingRepoSearchRepository
import com.gojek.trendingrepos.data.mappers.toDomain
import com.gojek.trendingrepos.data.source.TrendingRepoSearchDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Co-ordinates data sources exposing search results
 */
class TrendingRepoSearchRepository @Inject constructor(
    private val trendingRepoSearchDataSource: TrendingRepoSearchDataSource
) : ITrendingRepoSearchRepository {

    override suspend fun searchTrendingRepositories(): Flow<List<TrendingRepo>> {
        return trendingRepoSearchDataSource.query()
            .map { it.map { results -> results.toDomain() } }
    }

}