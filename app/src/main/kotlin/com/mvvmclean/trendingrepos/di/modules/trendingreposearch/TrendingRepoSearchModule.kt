package com.mvvmclean.trendingrepos.di.modules.trendingreposearch

import com.mvvmclean.trendingrepos.data.api.TrendingRepoApiService
import com.mvvmclean.trendingrepos.data.db.TrendingRepoDao
import com.mvvmclean.trendingrepos.data.repository.TrendingRepoSearchRepository
import com.mvvmclean.trendingrepos.data.source.TrendingRepoSearchDataSource
import com.mvvmclean.trendingrepos.data.utils.SharedPrefsHelper
import com.mvvmclean.trendingrepos.domain.usecases.TrendingRepositoryUseCase
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


