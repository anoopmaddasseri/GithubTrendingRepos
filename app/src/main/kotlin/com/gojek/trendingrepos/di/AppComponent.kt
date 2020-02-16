package com.gojek.trendingrepos.di

import android.content.Context
import com.gojek.trendingrepos.GojekTrendingReposApplication
import com.gojek.trendingrepos.di.modules.ActivityBuilderModule
import com.gojek.trendingrepos.di.modules.TrendingRepoApiModule
import com.gojek.trendingrepos.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Core Application Dagger Component
 */
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        TrendingRepoApiModule::class,
        ActivityBuilderModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    fun inject(app: GojekTrendingReposApplication)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

}

