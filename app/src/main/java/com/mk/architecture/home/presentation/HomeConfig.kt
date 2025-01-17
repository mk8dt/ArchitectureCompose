package com.mk.architecture.home.presentation

import com.mk.architecture.core.manager.error.ResultException.Forbidden
import com.mk.architecture.core.manager.error.ResultException.NotFound
import com.mk.architecture.home.domain.models.Product
import com.mk.architecture.main.ScreenConfig
import com.mk.architecture.main.UiState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow

class HomeScreenConfig : ScreenConfig<List<Product>, HomeEffect> {

    override val state = MutableStateFlow(UiState<List<Product>>())
    override val effects = Channel<HomeEffect>()
    override fun mapToScreenError(throwable: Throwable): String =
        when (throwable) {
            is NotFound -> "Producto no encontrado"
            is Forbidden -> "Revisa tus permisos de compras"
            else -> throwable.message ?: "Ha ocurrido un error"
        }
}

sealed interface HomeAction {
    data object InitScreen : HomeAction
    data class OnProductClick(val productId: Int) : HomeAction
}

sealed interface HomeEffect {
    data class NavigateToDetail(val productId: Int) : HomeEffect
}
