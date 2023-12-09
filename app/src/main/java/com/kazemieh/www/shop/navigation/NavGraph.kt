package com.kazemieh.www.shop.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.kazemieh.www.shop.ui.screens.basket.BasketScreen
import com.kazemieh.www.shop.ui.screens.category.CategoryScreen
import com.kazemieh.www.shop.ui.screens.home.HomeScreen
import com.kazemieh.www.shop.ui.screens.profile.ProfileScreen
import com.kazemieh.www.shop.ui.screens.SplashScreen
import com.kazemieh.www.shop.ui.screens.checkout.CheckoutScreen
import com.kazemieh.www.shop.ui.screens.checkout.ConfirmPurchaseScreen
import com.kazemieh.www.shop.ui.screens.home.WebPageScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Checkout.route
    ) {

        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.Category.route) {
            CategoryScreen(navController = navController)
        }

        composable(route = Screen.Basket.route) {
            BasketScreen(navController = navController)
        }

        composable(route = Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }

        composable(
            route = Screen.WebView.route + "?url={url}",
            arguments = listOf(navArgument("url") {
                type = NavType.StringType
                defaultValue = ""
                nullable = true
            })
        ) {
            val url = it.arguments?.getString("url")
            url?.let {
                WebPageScreen(navController = navController, url = it)
            }
        }

        composable(route = Screen.Checkout.route) {
            CheckoutScreen(navController = navController)
        }

        composable(
            route = Screen.ConfirmPurchase.route + "/{orderId}/{orderPrice}",
            arguments = listOf(
                navArgument("orderId") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                },
                navArgument("orderPrice") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                }
            )
        ) {

            it.arguments?.getString("orderId")?.let { orderId ->
                it.arguments?.getString("orderPrice")?.let { orderPrice ->
                    ConfirmPurchaseScreen(
                        navController = navController,
                        orderId = orderId,
                        orderPrice = orderPrice
                    )
                }
            }
        }

    }
}