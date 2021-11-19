package com.colagom.lottery.domain.usecase

interface UseCase<T, U> {
    suspend operator fun invoke(param: T): U
}