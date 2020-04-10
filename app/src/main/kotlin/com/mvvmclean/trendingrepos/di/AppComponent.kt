package com.mvvmclean.trendingrepos.di

import android.content.Context
import com.mvvmclean.trendingrepos.GithubTrendingReposApplication
import com.mvvmclean.trendingrepos.di.modules.ActivityBuilderModule
import com.mvvmclean.trendingrepos.di.modules.ApplicationModule
import com.mvvmclean.trendingrepos.di.modules.TrendingRepoApiModule
import com.mvvmclean.trendingrepos.di.modules.ViewModelModule
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
        ApplicationModule::class,
        TrendingRepoApiModule::class,
        ActivityBuilderModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    fun inject(app: GithubTrendingReposApplication)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

}

