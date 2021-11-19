package com.colagom.lottery.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.colagom.lottery.android.theme.LotteryTheme
import com.colagom.lottery.android.ui.LotteryBottomNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LotteryApp()
        }
    }
}

enum class Screen {
    History, Create, Setting;

    val icon
        get() = when (this) {
            Create -> Icons.Filled.AddCircle
            History -> Icons.Filled.History
            Setting -> Icons.Filled.Settings
        }

    val stringRes
        get() = when (this) {
            Create -> R.string.create
            History -> R.string.history
            Setting -> R.string.setting
        }

    companion object {
        fun fromRoute(route: String?): Screen =
            when (route) {
                History.name -> History
                Setting.name -> Setting
                else -> Create
            }
    }
}

@Composable
fun LotteryApp() {
    LotteryTheme {
        val navController = rememberNavController()
        val backStackEntry by navController.currentBackStackEntryAsState()
        val selectedTab = Screen.fromRoute(
            backStackEntry?.destination?.route
        )

        Scaffold(
            bottomBar = {
                LotteryBottomNavigation(
                    onTabSelected = { navController.navigate(it.name) },
                    selectedTab = selectedTab
                )
            }
        ) { innerPadding ->
            LotteryNavHost(
                modifier = Modifier.padding(innerPadding),
                navController = navController
            )
        }
    }
}

@Composable
fun LotteryNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        startDestination = Screen.History.name,
        navController = navController
    ) {
        composable(Screen.Create.name) {

        }

        composable(Screen.History.name) {

        }

        composable(Screen.Setting.name) {

        }
    }
}