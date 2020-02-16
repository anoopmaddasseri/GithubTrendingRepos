package com.gojek.trendingrepos.data.source

import com.gojek.trendingrepos.data.api.TrendingRepoApiService
import com.gojek.trendingrepos.data.mappers.toEntity
import com.gojek.trendingrepos.data.models.entity.TrendingRepoEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TrendingRepoSearchDataSource @Inject constructor(private val apiService: TrendingRepoApiService) {

    /**
     * Takes in [params] to be used for the search
     * @return list of search results
     */
    suspend fun query(): Flow<List<TrendingRepoEntity>> {
        val searchResponse = apiService.searchTrendingRepositories()
        val searchDataModels = mutableListOf<TrendingRepoEntity>()
        for (searchResult in searchResponse) {
            searchDataModels.add(searchResult.toEntity())
        }
        return flow { emit(searchDataModels) }
    }

}