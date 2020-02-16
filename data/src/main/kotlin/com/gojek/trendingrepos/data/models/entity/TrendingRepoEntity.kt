package com.gojek.trendingrepos.data.models.entity

/**
 * Provides a shallow character model with minimal data
 */
data class TrendingRepoEntity(
    val author: String,
    val avatar: String,
    val description: String,
    val forks: Int,
    val language: String? = null,
    val languageColor: String? = null,
    val name: String,
    val stars: Int,
    val url: String
)