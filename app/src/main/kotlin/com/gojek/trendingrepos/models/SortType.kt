package com.gojek.trendingrepos.models

sealed class SortType {
    object SortByName : SortType()
    object SortByStars : SortType()
}