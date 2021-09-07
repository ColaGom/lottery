package com.colagom.lottery.network

import com.colagom.lottery.domain.model.Lottery
import io.ktor.client.*
import io.ktor.client.request.*

class LotteryApi(
    private val client: HttpClient,
    var baseUrl: String = "http://13.209.3.150:8080/api/lottery"
) {
    suspend fun gets() = client.get<Lottery>()
}