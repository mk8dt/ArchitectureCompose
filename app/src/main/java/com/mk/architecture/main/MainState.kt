package com.mk.architecture.main

data class UiState<T>(
    val loading: Boolean = false,
    val updateApp: Boolean = false,
    val errorMessage: String? = null,
    val data: T? = null
) {

    companion object {
        fun <T> loading() = UiState<T>(loading = true)
        fun <T> error(errorMessage: String) = UiState<T>(errorMessage = errorMessage)
        fun <T> success(data: T) = UiState(data = data)
        fun <T> updateApp() = UiState<T>(updateApp = true)
    }
}
