package com.gojek.trendingrepos.di.modules

import android.content.Context
import androidx.room.Room
import com.gojek.trendingrepos.data.db.AppDatabase
import com.gojek.trendingrepos.data.db.TrendingRepoDao
import com.gojek.trendingrepos.data.utils.AppExecutors
import com.gojek.trendingrepos.data.utils.DiskIOThreadExecutor
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
    fun provideDb(context: Context, @Named("dbName") dbName: String): AppDatabase {
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
    @Named("dbName")
    fun provideDatabaseName(): String = "TrendingRepo.db"

    @Singleton
    @Provides
    fun provideTrendingRepoDao(appDatabase: AppDatabase): TrendingRepoDao =
        appDatabase.trendingRepoDao()
}