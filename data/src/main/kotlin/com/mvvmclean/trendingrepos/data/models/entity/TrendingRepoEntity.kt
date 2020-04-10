package com.mvvmclean.trendingrepos.data.models.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Provides a shallow character model with minimal data
 */
@Entity(tableName = "TrendingRepoEntity")
data class TrendingRepoEntity(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "author")
    val author: String,
    @ColumnInfo(name = "avatar")
    val avatar: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "forks")
    val forks: Int,
    @ColumnInfo(name = "language")
    val language: String? = null,
    @ColumnInfo(name = "language_color")
    val languageColor: String? = null,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "stars")
    val stars: Int,
    @ColumnInfo(name = "url")
    val url: String
)