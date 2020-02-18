package com.gojek.trendingrepos.data.utils

interface GetTaskCallback<T> {
    fun onTaskLoaded(loadedTask: T)
    fun onDataNotAvailable()
}