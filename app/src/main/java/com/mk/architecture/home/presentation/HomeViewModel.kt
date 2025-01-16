package com.mk.architecture.home.presentation

import androidx.lifecycle.viewModelScope
import com.mk.architecture.home.domain.models.Product
import com.mk.architecture.home.domain.repository.HomeRepository
import com.mk.architecture.home.presentation.HomeAction.OnProductClick
import com.mk.architecture.home.presentation.HomeEffect.NavigateToDetail
import com.mk.architecture.main.MainViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : MainViewModel<List<Product>, HomeEffect, HomeAction>(HomeScreenConfig()) {

    override fun onViewCreated() {
        getData()
    }

    override fun onUserAction(action: HomeAction) {
        when (action) {
            is OnProductClick -> sendEffects(NavigateToDetail(action.productId))
        }
    }

    private fun getData() {
        viewModelScope.launch {
            manageRequest(
                showLoading = true,
                request = homeRepository.fetchData()
            )
        }
    }
}