package com.mk.architecture.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update

abstract class MainViewModel<DATA, EFFECT, ACTION>(
    val screenConfig: ScreenConfig<DATA, EFFECT>
) : ViewModel() {

    private val _state = screenConfig.state
    val state = screenConfig.state.asStateFlow()

    private val _effects = screenConfig.effects
    val effects = _effects.receiveAsFlow()

    abstract fun onViewCreated()

    abstract fun onUserAction(action: ACTION)

    protected fun showLoading() {
        _state.update { UiState.loading() }
    }

    protected fun success(data: DATA) {
        _state.update { UiState.success(data) }
    }

    protected fun showError(errorMessage: String) {
        _state.update { UiState.error(errorMessage) }
    }

    protected fun showUpdateAppDialog() {
        _state.update { UiState.updateApp() }
    }

    protected fun sendEffects(effect: EFFECT) {
        _effects.trySend(effect)
    }
}
