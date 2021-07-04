package com.theapache64.composeandroidtemplate.ui.screen.dashboard

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor() : ViewModel() {
    private val _greetings = MutableStateFlow<String>("Hello World!")
    val greetings = _greetings.asStateFlow()

    fun onClickMeClicked() {
        _greetings.value = "Hello Compose!"
    }
}