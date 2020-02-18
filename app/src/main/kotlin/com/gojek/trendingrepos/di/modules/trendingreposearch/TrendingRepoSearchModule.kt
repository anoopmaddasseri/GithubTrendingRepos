package com.gojek.trendingrepos.di.modules.trendingreposearch

import com.gojek.trendingrepos.data.api.TrendingRepoApiService
import com.gojek.trendingrepos.data.db.TrendingRepoDao
import com.gojek.trendingrepos.data.repository.TrendingRepoSearchRepository
import com.gojek.trendingrepos.data.source.TrendingRepoSearchDataSource
import com.gojek.trendingrepos.data.utils.SharedPrefsHelper
import com.gojek.trendingrepos.domain.usecases.TrendingRepositoryUseCase
import dagger.Module
import dagger.Provides

@Module
open class TrendingRepoSearchModule {
    @Provides
    fun provideTrendingRepoSearchUseCase(
        trendingRepoSearchRepository: TrendingRepoSearchRepository
    ): TrendingRepositoryUseCase =
        TrendingRepositoryUseCase(trendingRepoSearchRepository)

    @Provides
    fun provideTrendingRepoSearchDataSource(
        apiService: TrendingRepoApiService,
        trendingRepoDao: TrendingRepoDao,
        sharedPrefsHelper: SharedPrefsHelper
    ): TrendingRepoSearchDataSource =
        TrendingRepoSearchDataSource(apiService, trendingRepoDao, sharedPrefsHelper)
}


