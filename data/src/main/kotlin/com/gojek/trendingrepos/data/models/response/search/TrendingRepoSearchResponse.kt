package com.gojek.trendingrepos.data.models.response.search

import com.gojek.trendingrepos.data.models.response.TrendingRepoResponse

data class TrendingRepoSearchResponse(
    val count: Int,
    val next: Any,
    val previous: Any,
    val data: List<TrendingRepoResponse>
)