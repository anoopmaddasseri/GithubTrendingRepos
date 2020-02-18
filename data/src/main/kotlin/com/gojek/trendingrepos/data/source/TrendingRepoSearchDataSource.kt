package com.gojek.trendingrepos.data.source

import com.gojek.trendingrepos.data.api.TrendingRepoApiService
import com.gojek.trendingrepos.data.db.TrendingRepoDao
import com.gojek.trendingrepos.data.mappers.toEntity
import com.gojek.trendingrepos.data.models.entity.TrendingRepoEntity
import com.gojek.trendingrepos.data.utils.AppLogger
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TrendingRepoSearchDataSource @Inject constructor(
    private val apiService: TrendingRepoApiService,
    private val trendingRepoDao: TrendingRepoDao
) {

    /**
     * Takes in [params] to be used for the search
     * @return list of search results
     */
    suspend fun query(forceRefresh: Boolean): Flow<List<TrendingRepoEntity>> {
        if (forceRefresh) {
            AppLogger.logD(
                TrendingRepoSearchDataSource::class.java.name,
                "{Clearing cache - action Force Refresh}"
            )
            trendingRepoDao.deleteAllTrendingRepos()
        } else {
            val isCacheAvailable = trendingRepoDao.isReposCacheAvailable() > 0
            if (isCacheAvailable) {
                AppLogger.logD(
                    TrendingRepoSearchDataSource::class.java.name,
                    "{Cache Found}"
                )
                return flow { emit(trendingRepoDao.allTrendingRepos()) }
            }
        }
        val searchResponse = apiService.searchTrendingRepositories()
        val searchDataModels = mutableListOf<TrendingRepoEntity>()
        searchResponse.forEachIndexed { index, searchResult ->
            searchDataModels.add(searchResult.toEntity(index))
        }

        //save to data base
        trendingRepoDao.saveTrendingRepos(searchDataModels)

        return flow { emit(searchDataModels) }
    }
}