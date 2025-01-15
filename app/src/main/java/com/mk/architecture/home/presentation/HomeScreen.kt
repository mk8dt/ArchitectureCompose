package com.mk.architecture.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mk.architecture.detail.Detail
import com.mk.architecture.detail.Detail.createRoute
import com.mk.architecture.home.domain.models.Product
import com.mk.architecture.home.presentation.HomeAction.OnProductClick
import com.mk.architecture.home.presentation.HomeEffect.NavigateToDetail
import com.mk.architecture.home.presentation.components.ProductItem
import com.mk.architecture.main.MainScreen
import com.mk.architecture.main.UiState
import com.mk.architecture.mockdata.productList
import com.mk.architecture.core.ui.components.loading.MainLoading

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    MainScreen(
        viewModel = viewModel,
        content = { state -> Screen(state, viewModel::onUserAction) },
        effect = { homeEffect ->
            when (homeEffect) {
                is NavigateToDetail -> navController.navigate(createRoute(homeEffect.productId))
            }
        }
    )
}

@Composable
fun Screen(
    state: UiState<List<Product>>,
    action: (HomeAction) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        if (state.loading) {
            MainLoading()

            return@Column
        }

        state.data?.let { productList ->
            LazyColumn {
                items(productList) { product ->
                    ProductItem(
                        product = product,
                        onClick = { action(OnProductClick(it)) }
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Screen(
        state = UiState.success(productList()),
        action = {}
    )
}