package com.mk.architecture.main

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow

interface ScreenConfig<DATA, EFFECT> {
    val state: MutableStateFlow<UiState<DATA>>
    val effects: Channel<EFFECT>
    fun mapToScreenError(throwable: Throwable): String
}