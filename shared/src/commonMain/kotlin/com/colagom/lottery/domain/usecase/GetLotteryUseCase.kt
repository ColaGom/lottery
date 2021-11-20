package com.colagom.lottery.domain.usecase

import com.colagom.lottery.domain.LotteryRepository
import com.colagom.lottery.domain.model.Lottery
import kotlinx.coroutines.flow.Flow

class GetLotteryUseCase(
    private val lotteryRepository: LotteryRepository
) : FlowUseCase<Unit, List<Lottery>> {
    override suspend fun invoke(param: Unit): Flow<List<Lottery>> {
        return lotteryRepository.get()
    }
}