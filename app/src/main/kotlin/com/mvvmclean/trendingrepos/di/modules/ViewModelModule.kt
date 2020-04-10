package com.mvvmclean.trendingrepos.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mvvmclean.trendingrepos.di.ViewModelKey
import com.mvvmclean.trendingrepos.di.factory.ViewModelFactory
import com.mvvmclean.trendingrepos.features.trendingrepo.TrendingRepositoryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @IntoMap
    @Binds
    @ViewModelKey(TrendingRepositoryViewModel::class)
    abstract fun bindCharacterSearchViewModel(trendingRepositoryViewModel: TrendingRepositoryViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}