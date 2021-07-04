package com.theapache64.composeandroidtemplate.ui.screen.splash

import androidx.lifecycle.ViewModel
import com.theapache64.composeandroidtemplate.BuildConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {
    private val _versionName = MutableStateFlow<String>("v${BuildConfig.VERSION_NAME}")
    val versionName = _versionName.asStateFlow()
}