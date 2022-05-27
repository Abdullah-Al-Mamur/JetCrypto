package com.shimul.jetcrypto.domain.repositories

import com.shimul.jetcrypto.data.remote.dto.CoinDetailDto
import com.shimul.jetcrypto.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins() : List<CoinDto>
    suspend fun getCoinById(coinId: String) : CoinDetailDto
}