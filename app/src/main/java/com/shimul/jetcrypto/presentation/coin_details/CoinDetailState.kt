package com.shimul.jetcrypto.presentation.coin_details

import com.shimul.jetcrypto.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coinDetail: CoinDetail? = null,
    val error: String = ""
)