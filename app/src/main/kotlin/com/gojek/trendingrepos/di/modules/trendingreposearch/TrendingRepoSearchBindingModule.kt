package com.gojek.trendingrepos.di.modules.trendingreposearch

import com.gojek.trendingrepos.domain.repository.ITrendingRepoSearchRepository
import com.gojek.trendingrepos.data.repository.TrendingRepoSearchRepository
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