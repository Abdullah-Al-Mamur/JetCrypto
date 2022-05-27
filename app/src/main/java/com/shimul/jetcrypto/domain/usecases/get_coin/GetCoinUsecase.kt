package com.shimul.jetcrypto.domain.usecases.get_coin

import com.shimul.jetcrypto.common.Resource
import com.shimul.jetcrypto.data.remote.dto.toEntity
import com.shimul.jetcrypto.domain.model.CoinDetail
import com.shimul.jetcrypto.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUsecase @Inject constructor(
    private val coinRepository: CoinRepository
){
    operator fun invoke(coinId: String) : Flow<Resource<CoinDetail>> = flow{
        emit(Resource.Loading())
        try {
            val coinDetail: CoinDetail = coinRepository.getCoinById(coinId).toEntity()
            emit(Resource.Success(data = coinDetail))
        }catch (e: HttpException){
            emit(Resource.Error(message = e.localizedMessage ?: "Unexpected error occurred."))
        }
    }
}