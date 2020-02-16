package com.gojek.trendingrepos.data.repository

import com.gojek.trendingrepos.data.source.TrendingRepoSearchDataSource
import com.gojek.trendingrepos.domain.repository.ITrendingRepoSearchRepository
import javax.inject.Inject

/**
 * Co-ordinates data sources exposing search results
 */
class TrendingRepoSearchRepository @Inject constructor(
    private val trendingRepoSearchDataSource: TrendingRepoSearchDataSource
) : ITrendingRepoSearchRepository {

}