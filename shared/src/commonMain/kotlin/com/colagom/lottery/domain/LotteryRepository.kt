package com.colagom.lottery.domain

import com.colagom.lottery.domain.model.Lottery
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

interface LotteryRepository {
    suspend fun get(): Flow<List<Lottery>>
}

class DummyLotteryRepository : LotteryRepository {
    override suspend fun get(): Flow<List<Lottery>> = flow {
        emit(List(100, ::random))
    }

    companion object {
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
}