package com.kazemieh.www.shop.navigation

sealed class Screen(val route: String) {
    data object Splash : Screen("splash_screen")
    data object Home : Screen("HomeScreen_screen")
    data object Category : Screen("Category_screen")
    data object Basket : Screen("Basket_screen")
    data object Profile : Screen("Profile_screen")
    data object WebView : Screen("WebView_screen")
    data object Checkout : Screen("Checkout_screen")
    data object ConfirmPurchase : Screen("ConfirmPurchase_screen")
    data object ProductDetail : Screen("ProductDetail_screen")
    data object ProductDescription : Screen("ProductDescription_screen")

    fun withArgs(vararg args: Any): String {
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }

}