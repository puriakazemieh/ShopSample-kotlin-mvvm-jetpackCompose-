package com.kazemieh.www.shop.ui.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.kazemieh.www.shop.navigation.Screen
import com.kazemieh.www.shop.ui.theme.cardBackground
import com.kazemieh.www.shop.ui.theme.splashBg

@Composable
fun ChangeStatusBarColor(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val systemUiController = rememberSystemUiController()

    when (navBackStackEntry?.destination?.route) {
        Screen.Splash.route -> {
            val color = MaterialTheme.colorScheme.splashBg
            SideEffect {
                systemUiController.setStatusBarColor(
                    color = color
                )
            }
        }

        else -> {
            val color=MaterialTheme.colorScheme.cardBackground
            SideEffect {
                systemUiController.setStatusBarColor(
                    color = color
                )
            }

        }
    }
}
