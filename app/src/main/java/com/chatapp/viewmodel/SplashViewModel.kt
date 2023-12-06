package com.chatapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    private val _navigationTrigger = MutableStateFlow(false)
    val navigationTrigger: StateFlow<Boolean> = _navigationTrigger.asStateFlow()

    val shouldNavigateToMain: Boolean
        get() = _navigationTrigger.value

    fun onNavigateToMain() {
        _navigationTrigger.value = true
    }
}
