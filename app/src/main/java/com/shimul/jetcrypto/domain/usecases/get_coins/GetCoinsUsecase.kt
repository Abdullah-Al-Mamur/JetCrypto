package com.shimul.jetcrypto.domain.usecases.get_coins

import com.shimul.jetcrypto.common.Resource
import com.shimul.jetcrypto.data.remote.dto.toEntity
import com.shimul.jetcrypto.domain.model.Coin
import com.shimul.jetcrypto.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUsecase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        emit(Resource.Loading())
        try {
            val coins: List<Coin> = coinRepository.getCoins().map { it.toEntity() }
            emit(Resource.Success(data = coins))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Couldn't reach the server, please check your internet connection."))
        }
    }
}