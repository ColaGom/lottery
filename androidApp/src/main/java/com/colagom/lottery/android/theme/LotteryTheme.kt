package com.colagom.lottery.android.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.colagom.lottery.android.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun LotteryTheme(content: @Composable () -> Unit) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(color = Primary)

    MaterialTheme(
        colors = ColorPalette,
        typography = Typography(BlackHan),
        content = content
    )
}

private val BlackHan = FontFamily(
    Font(R.font.blackhansans_regular)
)