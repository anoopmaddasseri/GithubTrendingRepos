package com.mvvmclean.trendingrepos.commons

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler

/**
 * This view model is used to represent the current state of the UI
 */
abstract class UiStateViewModel : ViewModel() {

    val uiState: LiveData<UiState>
        get() = _uiState

    protected var _uiState = MutableLiveData<UiState>()

    protected val handler = CoroutineExceptionHandler { _, exception ->
        _uiState.value = Error(exception)
    }

    abstract fun onDestroy(lifecycleOwner: LifecycleOwner)

}