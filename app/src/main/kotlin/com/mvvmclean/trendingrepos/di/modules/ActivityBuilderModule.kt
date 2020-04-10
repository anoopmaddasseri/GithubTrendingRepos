/*
 * @author   Anoop Maddasseri <anoopmaddasseri@gmail.com>
 * @version  1
 * @since    16th Feb 2020
 *
 * P.S. Increment version when editing
 */
package com.mvvmclean.trendingrepos.di.modules

import com.mvvmclean.trendingrepos.base.BaseActivity
import com.mvvmclean.trendingrepos.di.ActivityScope
import com.mvvmclean.trendingrepos.di.modules.base.BaseBindingModule
import com.mvvmclean.trendingrepos.di.modules.base.BaseModule
import com.mvvmclean.trendingrepos.di.modules.trendingreposearch.TrendingRepoSearchBindingModule
import com.mvvmclean.trendingrepos.di.modules.trendingreposearch.TrendingRepoSearchModule
import com.mvvmclean.trendingrepos.features.trendingrepo.TrendingRepoSearchActivity
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