/*
 * @author   Anoop Maddasseri <anoopmaddasseri@gmail.com>
 * @version  1
 * @since    16th Feb 2020
 *
 * P.S. Increment version when editing
 */
package com.gojek.trendingrepos.di.modules

import com.gojek.trendingrepos.base.BaseActivity
import com.gojek.trendingrepos.di.ActivityScope
import com.gojek.trendingrepos.di.modules.base.BaseBindingModule
import com.gojek.trendingrepos.di.modules.base.BaseModule
import com.gojek.trendingrepos.di.modules.trendingreposearch.TrendingRepoSearchBindingModule
import com.gojek.trendingrepos.di.modules.trendingreposearch.TrendingRepoSearchModule
import com.gojek.trendingrepos.features.trendingrepo.TrendingRepoSearchActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [BaseBindingModule::class, TrendingRepoSearchBindingModule::class])
abstract class ActivityBuilderModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [BaseModule::class])
    abstract fun provideBaseActivity(): BaseActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [TrendingRepoSearchModule::class])
    abstract fun provideSearchActivity(): TrendingRepoSearchActivity
}