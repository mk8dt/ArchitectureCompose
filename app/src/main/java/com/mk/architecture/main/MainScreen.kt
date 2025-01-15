package com.mk.architecture.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mk.architecture.core.ui.components.dialog.UpdateAppDialog
import com.mk.architecture.core.ui.extension.ObserveEffect

@Composable
fun <DATA, EFFECT, ACTION> MainScreen(
    viewModel: MainViewModel<DATA, EFFECT, ACTION>,
    content: @Composable (UiState<DATA>) -> Unit,
    effect: (EFFECT) -> Unit
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.onViewCreated()
    }

    ObserveEffect(viewModel.effects) {
        effect(it)
    }

    if (state.updateApp) {
        UpdateAppDialog()

        return
    }

    content(state)
}