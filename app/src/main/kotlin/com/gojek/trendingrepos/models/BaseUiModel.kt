package com.gojek.trendingrepos.models

interface BaseUiModel {
    fun toString(value: Int) = "$value"
    fun getDefault(value: String?, default: String) =
        if (value?.isNotEmpty() == true) value else default
}