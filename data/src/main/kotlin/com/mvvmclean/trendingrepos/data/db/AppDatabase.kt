package com.mvvmclean.trendingrepos.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mvvmclean.trendingrepos.data.models.entity.TrendingRepoEntity

@Database(entities = [TrendingRepoEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun trendingRepoDao(): TrendingRepoDao
}