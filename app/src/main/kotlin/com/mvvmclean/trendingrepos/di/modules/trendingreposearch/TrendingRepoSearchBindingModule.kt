package com.mvvmclean.trendingrepos.di.modules.trendingreposearch

import com.mvvmclean.trendingrepos.domain.repository.ITrendingRepoSearchRepository
import com.mvvmclean.trendingrepos.data.repository.TrendingRepoSearchRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class TrendingRepoSearchBindingModule {

    @Singleton
    @Binds
    abstract fun bindTrendingRepoRepository(
        trendingRepoSearchRepository: TrendingRepoSearchRepository
    ): ITrendingRepoSearchRepository

}