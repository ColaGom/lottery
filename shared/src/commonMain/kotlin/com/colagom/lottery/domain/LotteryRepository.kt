package com.colagom.lottery.domain

import com.colagom.lottery.domain.model.Lottery
import kotlin.random.Random

interface LotteryRepository {
    suspend fun get(): List<Lottery>
}

class DummyLotteryRepository : LotteryRepository {
    override suspend fun get(): List<Lottery> = List(100, ::random)

    private fun random(drwNum: Int) = Lottery(
        drwNo = drwNum,
        Random.nextInt(45),
        "",
        Random.nextInt(45),
        Random.nextInt(45),
        Random.nextInt(45),
        Random.nextInt(45),
        Random.nextInt(45),
        Random.nextInt(45),
        Random.nextLong(),
        Random.nextLong(),
        Random.nextLong(),
    )
}