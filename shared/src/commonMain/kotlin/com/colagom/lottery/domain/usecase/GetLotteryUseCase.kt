package com.colagom.lottery.domain.usecase

import com.colagom.lottery.domain.LotteryRepository
import com.colagom.lottery.domain.model.Lottery

class GetLotteryUseCase(
    private val lotteryRepository: LotteryRepository
) : UseCase<Unit, List<Lottery>> {
    override suspend fun invoke(param: Unit): List<Lottery> {
        return lotteryRepository.get()
    }
}