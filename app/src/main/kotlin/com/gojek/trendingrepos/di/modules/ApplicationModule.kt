package com.gojek.trendingrepos.di.modules

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.gojek.trendingrepos.data.db.AppDatabase
import com.gojek.trendingrepos.data.db.TrendingRepoDao
import com.gojek.trendingrepos.data.utils.AppExecutors
import com.gojek.trendingrepos.data.utils.DiskIOThreadExecutor
import com.gojek.trendingrepos.data.utils.SharedPrefsHelper
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * This is a Dagger provider module
 */
@Module
class ApplicationModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(
            SharedPrefsHelper.PREF_NAME,
            Context.MODE_PRIVATE
        )
    }

    @Singleton
    @Provides
    fun provideDb(context: Context, @Named("databaseName") dbName: String): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            dbName
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideAppExecutors(): AppExecutors {
        return AppExecutors(
            DiskIOThreadExecutor(),
            AppExecutors.MainThreadExecutor()
        )
    }

    @Provides
    @Named("databaseName")
    fun provideDatabaseName(): String = "TrendingRepo.db"

    @Singleton
    @Provides
    fun provideTrendingRepoDao(appDatabase: AppDatabase): TrendingRepoDao =
        appDatabase.trendingRepoDao()
}