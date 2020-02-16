package com.gojek.trendingrepos.data.mappers

import com.gojek.trendingrepos.data.models.entity.TrendingRepoEntity
import com.gojek.trendingrepos.data.models.response.TrendingRepoResponse

internal fun TrendingRepoResponse.toEntity(): TrendingRepoEntity {
    return TrendingRepoEntity(
        this.author,
        this.avatar,
        this.description,
        this.forks,
        this.language,
        this.languageColor,
        this.name,
        this.stars,
        this.url
    )
}