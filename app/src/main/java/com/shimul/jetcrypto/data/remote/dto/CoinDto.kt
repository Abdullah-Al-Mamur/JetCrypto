package com.shimul.jetcrypto.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.shimul.jetcrypto.domain.model.Coin

data class CoinDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("type")
    val type: String
)

fun CoinDto.toEntity(): Coin{
    return  Coin(
        id = id,
        is_active = isActive,
        is_new = isNew,
        name = name,
        rank = rank,
        symbol = symbol,
    );
}