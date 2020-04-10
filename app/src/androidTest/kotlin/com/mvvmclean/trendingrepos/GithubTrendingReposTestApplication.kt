package com.mvvmclean.trendingrepos

import com.mvvmclean.trendingrepos.di.AppComponent
import com.mvvmclean.trendingrepos.di.DaggerTestApplicationComponent


class GithubTrendingReposTestApplication : GithubTrendingReposApplication() {

    override fun onCreate() {
        super.onCreate()
        getApplicationComponent().inject(this)
    }

    override fun getApplicationComponent(): AppComponent {
        return DaggerTestApplicationComponent.factory()
            .create(applicationContext)
    }

}