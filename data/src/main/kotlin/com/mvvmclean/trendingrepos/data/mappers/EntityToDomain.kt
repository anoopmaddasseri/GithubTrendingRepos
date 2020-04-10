package com.mvvmclean.trendingrepos.data.mappers

import com.mvvmclean.trendingrepos.data.models.entity.TrendingRepoEntity
import com.mvvmclean.trendingrepos.domain.models.TrendingRepo

internal fun TrendingRepoEntity.toDomain(): TrendingRepo {
    return TrendingRepo(
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