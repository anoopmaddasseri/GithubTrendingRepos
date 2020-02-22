package com.gojek.trendingrepos.di

import android.content.Context
import com.gojek.trendingrepos.di.modules.ActivityBuilderModule
import com.gojek.trendingrepos.di.modules.ApplicationModule
import com.gojek.trendingrepos.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        FakeTrendingRepoApiModule::class,
        ActivityBuilderModule::class,
        ViewModelModule::class
    ]
)
interface TestApplicationComponent : AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): TestApplicationComponent
    }

}