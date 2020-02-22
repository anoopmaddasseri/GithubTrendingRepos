package com.gojek.trendingrepos

import com.gojek.trendingrepos.di.AppComponent
import com.gojek.trendingrepos.di.DaggerTestApplicationComponent


class GojekTrendingReposTestApplication : GojekTrendingReposApplication() {

    override fun onCreate() {
        super.onCreate()
        getApplicationComponent().inject(this)
    }

    override fun getApplicationComponent(): AppComponent {
        return DaggerTestApplicationComponent.factory()
            .create(applicationContext)
    }

}