package com.shimul.jetcrypto.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shimul.jetcrypto.common.Resource
import com.shimul.jetcrypto.domain.usecases.get_coins.GetCoinsUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject  constructor(
    private val getCoinsUsecase: GetCoinsUsecase
) : ViewModel(){
    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins(){
        getCoinsUsecase().onEach {
            result ->
            when(result){
                is Resource.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true,)
                }
                is Resource.Error -> {
                    _state.value = CoinListState(error = result.message ?: "Unknown error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }
}