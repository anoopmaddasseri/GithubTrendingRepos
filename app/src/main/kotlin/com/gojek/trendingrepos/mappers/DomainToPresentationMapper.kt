package com.gojek.trendingrepos.mappers

import com.gojek.trendingrepos.domain.models.TrendingRepo
import com.gojek.trendingrepos.models.TrendingRepositoryUiModel

fun TrendingRepo.toPresentation(): TrendingRepositoryUiModel {
    return TrendingRepositoryUiModel(
        this.author,
        this.avatar,
        this.description,
        this.forks,
        this.language,
        this.languageColor,
        this.name,
        this.stars,
        this.url,
        false
    )
}