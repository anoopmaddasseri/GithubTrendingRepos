package com.gojek.trendingrepos.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gojek.trendingrepos.di.ViewModelKey
import com.gojek.trendingrepos.di.factory.ViewModelFactory
import com.gojek.trendingrepos.features.trendingrepo.TrendingRepositoryViewModel
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