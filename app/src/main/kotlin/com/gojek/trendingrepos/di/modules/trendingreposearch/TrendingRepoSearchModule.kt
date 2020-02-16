package com.gojek.trendingrepos.di.modules.trendingreposearch

import com.gojek.trendingrepos.data.api.TrendingRepoApiService
import com.gojek.trendingrepos.data.repository.TrendingRepoSearchRepository
import com.gojek.trendingrepos.data.source.TrendingRepoSearchDataSource
import com.gojek.trendingrepos.domain.usecases.TrendingRepositoryUseCase
import dagger.Module
import dagger.Provides

@Module
class TrendingRepoSearchModule {

    @Provides
    fun provideTrendingRepoSearchUseCase(
        trendingRepoSearchRepository: TrendingRepoSearchRepository
    ): TrendingRepositoryUseCase =
        TrendingRepositoryUseCase(trendingRepoSearchRepository)

    @Provides
    fun provideTrendingRepoSearchDataSource(apiService: TrendingRepoApiService): TrendingRepoSearchDataSource =
        TrendingRepoSearchDataSource(apiService)

}


