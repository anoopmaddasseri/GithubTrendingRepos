package com.gojek.trendingrepos.data.mappers

import com.gojek.trendingrepos.data.models.entity.TrendingRepoEntity
import com.gojek.trendingrepos.domain.models.TrendingRepo

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