package com.mvvmclean.trendingrepos.data.mappers

import com.mvvmclean.trendingrepos.data.models.entity.TrendingRepoEntity
import com.mvvmclean.trendingrepos.data.models.response.TrendingRepoResponse

internal fun TrendingRepoResponse.toEntity(primaryKey: Int): TrendingRepoEntity {
    return TrendingRepoEntity(
        primaryKey,
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