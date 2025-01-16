package com.mk.architecture.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mk.architecture.core.manager.error.ResultException.UpdateAppNeeded
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class MainViewModel<DATA, EFFECT, ACTION>(
    val screenConfig: ScreenConfig<DATA, EFFECT>
) : ViewModel() {

    private val _state = screenConfig.state
    val state = screenConfig.state.asStateFlow()

    private val _effects = screenConfig.effects
    val effects = _effects.receiveAsFlow()

    abstract fun onViewCreated()

    abstract fun onUserAction(action: ACTION)

    fun manageRequest(
        showLoading: Boolean,
        request: Result<DATA>
    ) = viewModelScope.launch {
        if (showLoading) showLoading()

        request
            .onFailure { manageError(it) }
            .onSuccess { success(it) }
    }

    private fun manageError(throwable: Throwable) {
        when (throwable) {
            is UpdateAppNeeded -> showUpdateAppDialog()
            else -> showError(screenConfig.mapToScreenError(throwable))
        }
    }

    protected fun showLoading() {
        _state.update { UiState.loading() }
    }

    private fun success(data: DATA) {
        _state.update { UiState.success(data) }
    }

    private fun showError(errorMessage: String) {
        _state.update { UiState.error(errorMessage) }
    }

    private fun showUpdateAppDialog() {
        _state.update { UiState.updateApp() }
    }

    protected fun sendEffects(effect: EFFECT) {
        _effects.trySend(effect)
    }
}
