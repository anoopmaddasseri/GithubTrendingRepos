/*
 * @author   Anoop Maddasseri <anoopmaddasseri@gmail.com>
 * @version  1
 * @since    18th Feb 2020
 *
 * P.S. Increment version when editing
 */
package com.mvvmclean.trendingrepos.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mvvmclean.trendingrepos.data.models.entity.TrendingRepoEntity

/**
 * Data Access Object for the UserProductCart entity
 */
@Dao
interface TrendingRepoDao {
    /**
     * Select all cart from the TrendingRepoEntity.
     *
     * @return all products in cart.
     */
    @Query("SELECT * FROM TrendingRepoEntity")
    suspend fun allTrendingRepos(): List<TrendingRepoEntity>

    /**
     * Insert all repose
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTrendingRepos(userProductCart: List<TrendingRepoEntity?>?)

    /**
     * Delete all repos
     */
    @Query("DELETE FROM TrendingRepoEntity")
    suspend fun deleteAllTrendingRepos()

    /**
     * Delete all repos
     */
    @Query("SELECT COUNT(*) FROM TrendingRepoEntity")
    suspend fun isReposCacheAvailable(): Int
}