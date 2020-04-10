package com.mvvmclean.trendingrepos.mappers

import com.mvvmclean.trendingrepos.domain.models.TrendingRepo
import com.mvvmclean.trendingrepos.models.TrendingRepositoryUiModel

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