package com.mvvmclean.trendingrepos.data.source

import com.mvvmclean.trendingrepos.data.api.TrendingRepoApiService
import com.mvvmclean.trendingrepos.data.db.TrendingRepoDao
import com.mvvmclean.trendingrepos.data.mappers.toEntity
import com.mvvmclean.trendingrepos.data.models.entity.TrendingRepoEntity
import com.mvvmclean.trendingrepos.data.utils.AppLogger
import com.mvvmclean.trendingrepos.data.utils.SharedPrefsHelper
import com.mvvmclean.trendingrepos.data.utils.isTimeWithInInterval
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TrendingRepoSearchDataSource @Inject constructor(
    private val apiService: TrendingRepoApiService,
    private val trendingRepoDao: TrendingRepoDao,
    private val sharedPrefsHelper: SharedPrefsHelper
) {

    /**
     * Takes in [params] to be used for the search
     * @return list of search results
     */
    suspend fun query(forceRefresh: Boolean): Flow<List<TrendingRepoEntity>> {
        val syncUpIntervalInSeconds = 2L * 3_600
        val isCacheAvailable = trendingRepoDao.isReposCacheAvailable() > 0
        val lastSyncUpTime =
            sharedPrefsHelper[SharedPrefsHelper.PREF_KEY_REPO_LAST_UPDATED_TIME, 0L]
        val isTimeSurpassed =
            isTimeWithInInterval(
                syncUpIntervalInSeconds,
                System.currentTimeMillis(),
                lastSyncUpTime
            )
        if (forceRefresh) {
            AppLogger.logD(
                TrendingRepoSearchDataSource::class.java.name,
                "{Clearing cache - action Force Refresh}"
            )
            trendingRepoDao.deleteAllTrendingRepos()
        } else if (isCacheAvailable && !isTimeSurpassed) {
            AppLogger.logD(
                TrendingRepoSearchDataSource::class.java.name, "{Cache Found}"
            )
            return flow { emit(trendingRepoDao.allTrendingRepos()) }
        }
        val searchResponse = apiService.searchTrendingRepositories()
        val searchDataModels = mutableListOf<TrendingRepoEntity>()
        searchResponse.forEachIndexed { index, searchResult ->
            searchDataModels.add(searchResult.toEntity(index))
        }
        //save to data base
        trendingRepoDao.saveTrendingRepos(searchDataModels)
        //update time after a successful sync up with backend
        sharedPrefsHelper.put(
            SharedPrefsHelper.PREF_KEY_REPO_LAST_UPDATED_TIME,
            System.currentTimeMillis()
        )
        return flow { emit(searchDataModels) }
    }
}