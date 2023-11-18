package com.kazemieh.www.shop.navigation

sealed class Screen(val route: String) {
    data object Splash : Screen("splash_screen")
    data object Home : Screen("HomeScreen_screen")
    data object Category : Screen("Category_screen")
    data object Basket : Screen("Basket_screen")
    data object Profile : Screen("Profile_screen")

    fun withArgs(vararg args: Any): String {
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }

}