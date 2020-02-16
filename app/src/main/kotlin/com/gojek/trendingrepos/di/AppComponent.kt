/*
 * @author   Anoop Maddasseri <anoopmaddasseri@gmail.com>
 * @version  1
 * @since    16th Feb 2020
 *
 * P.S. Increment version when editing
 */
package com.gojek.trendingrepos.di

import android.content.Context
import com.gojek.trendingrepos.GojekTrendingReposApplication
import com.gojek.trendingrepos.di.modules.ActivityBuilderModule
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

