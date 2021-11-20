package com.colagom.lottery.domain.usecase

import kotlinx.coroutines.flow.Flow

interface UseCase<T, U> {
    suspend operator fun invoke(param: T): U
}

interface FlowUseCase<T, U> {
    suspend operator fun invoke(param: T): Flow<U>
}