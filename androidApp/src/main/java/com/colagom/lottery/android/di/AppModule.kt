package com.colagom.lottery.android.di

import com.colagom.lottery.android.HistoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HistoryViewModel(get()) }
}