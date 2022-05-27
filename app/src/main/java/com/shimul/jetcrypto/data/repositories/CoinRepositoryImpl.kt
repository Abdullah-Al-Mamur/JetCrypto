package com.shimul.jetcrypto.data.repositories

import com.shimul.jetcrypto.data.remote.CoinPaprikaApi
import com.shimul.jetcrypto.data.remote.dto.CoinDetailDto
import com.shimul.jetcrypto.data.remote.dto.CoinDto
import com.shimul.jetcrypto.domain.repositories.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinPaprikaApi: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return coinPaprikaApi.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return coinPaprikaApi.getCoinById(coinId)
    }
}