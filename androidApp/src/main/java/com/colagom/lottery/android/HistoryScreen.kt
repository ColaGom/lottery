package com.colagom.lottery.android

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.colagom.lottery.android.theme.LotteryTheme
import com.colagom.lottery.domain.model.Lottery
import com.colagom.lottery.domain.usecase.GetLotteryUseCase
import com.google.accompanist.flowlayout.FlowRow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import org.koin.androidx.compose.getViewModel
import kotlin.random.Random

class HistoryViewModel(
    private val getLotteryUseCase: GetLotteryUseCase
) : ViewModel() {
    val lotteries = flow {
        getLotteryUseCase(Unit).collect(::emit)
    }
}

@Composable
fun HistoryBody(
    modifier: Modifier = Modifier,
    listState: LazyListState = rememberLazyListState()
) {
    val viewModel: HistoryViewModel = getViewModel()
    val lotteries by viewModel.lotteries.collectAsState(initial = emptyList())

    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        state = listState
    ) {
        items(lotteries) { item ->
            LotteryRow(item = item)
        }
    }
}

@Composable
fun LotteryRow(item: Lottery) {
    Card(
        elevation = 4.dp
    ) {
        val drwNums = intArrayOf(
            item.drwtNo1,
            item.drwtNo2,
            item.drwtNo3,
            item.drwtNo4,
            item.drwtNo4,
            item.drwtNo5
        )
        drwNums.sort()

        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "${item.drwNo} 회차 당첨번호", style = MaterialTheme.typography.subtitle1)
            LotteryNumberRow(numbers = drwNums, item.bnusNo)
        }
    }
}

@Composable
fun LotteryNumberRow(vararg numbers: Int, bonusNum: Int) {
    FlowRow {
        numbers.forEach {
            Box(
                modifier = Modifier
                    .size(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = it.toString())
            }
        }

        Box(
            modifier = Modifier
                .size(32.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = bonusNum.toString())

            Text(
                text = "bonus",
                modifier = Modifier.align(Alignment.BottomCenter),
                fontSize = 8.sp,
            )
        }
    }
}

@Preview
@Composable
fun PreviewLotteryRow() {
    val dummy = Lottery(
        drwNo = 1,
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

    LotteryTheme {
        LotteryRow(item = dummy)
    }
}