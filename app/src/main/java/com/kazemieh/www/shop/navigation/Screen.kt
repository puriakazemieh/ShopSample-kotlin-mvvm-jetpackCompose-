package com.kazemieh.www.shop.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
}