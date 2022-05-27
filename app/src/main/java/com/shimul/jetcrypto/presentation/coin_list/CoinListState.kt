package com.shimul.jetcrypto.presentation.coin_list

import com.shimul.jetcrypto.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)