package com.mk.architecture.detail

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.mk.architecture.main.BASE_DEEPLINK
import com.mk.architecture.main.NavRoute

data object Detail : NavRoute("$BASE_DEEPLINK detail/{productId}") {

    override val arguments: List<NamedNavArgument> = listOf(
        navArgument("productId") { type = NavType.IntType },
    )

    fun createRoute(productId: Int) = "$BASE_DEEPLINK detail/$productId"
}