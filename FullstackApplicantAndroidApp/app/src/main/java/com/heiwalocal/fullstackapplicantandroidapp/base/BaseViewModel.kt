package com.heiwalocal.fullstackapplicantandroidapp.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel: ViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + SupervisorJob()

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }
}