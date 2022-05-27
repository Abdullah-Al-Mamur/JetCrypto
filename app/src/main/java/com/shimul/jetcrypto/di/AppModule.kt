package com.shimul.jetcrypto.di

import com.shimul.jetcrypto.common.Constants
import com.shimul.jetcrypto.data.remote.CoinPaprikaApi
import com.shimul.jetcrypto.data.repositories.CoinRepositoryImpl
import com.shimul.jetcrypto.domain.repositories.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideCoinPaprikaApi() : CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(coinPaprikaApi: CoinPaprikaApi): CoinRepository{
        return CoinRepositoryImpl(coinPaprikaApi)
    }
}