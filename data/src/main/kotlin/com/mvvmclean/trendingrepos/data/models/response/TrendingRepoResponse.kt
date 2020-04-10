package com.mvvmclean.trendingrepos.data.models.response

/**
 * Basic Character info
 */
data class TrendingRepoResponse(
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