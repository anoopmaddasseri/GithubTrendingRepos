package com.mvvmclean.trendingrepos.utils

import com.mvvmclean.trendingrepos.domain.models.TrendingRepo

object SampleData {
    val repoSearchResults = listOf(
        TrendingRepo(
            "Anoop M",
            "http://avatar.png",
            "Sample Git Repo",
            10,
            "Android",
            "#ff84",
            "Android Beacons",
            55,
            "http://git.com"
        )
    )
}