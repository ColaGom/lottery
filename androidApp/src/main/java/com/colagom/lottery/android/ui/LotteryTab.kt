package com.colagom.lottery.android.ui

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.colagom.lottery.android.Screen
import com.colagom.lottery.android.theme.LotteryTheme

@Composable
fun LotteryBottomNavigation(
    screens: Array<Screen> = Screen.values(),
    onTabSelected: (Screen) -> Unit,
    selectedTab: Screen
) {
    BottomNavigation {
        screens.forEach {
            BottomNavigationItem(
                icon = { Icon(it.icon, contentDescription = stringResource(it.stringRes)) },
                label = { Text(stringResource(it.stringRes)) },
                selected = selectedTab == it,
                onClick = {
                    onTabSelected(it)
                }
            )
        }
    }
}

@Preview
@Composable
private fun PreviewBottomNavigation() {
    LotteryTheme {
        LotteryBottomNavigation(
            onTabSelected = {},
            selectedTab = Screen.Create
        )
    }
}