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
import com.kazemieh.www.shop.ui.screens.productdetail.AllProductCommentsScreen
import com.kazemieh.www.shop.ui.screens.productdetail.NewCommentScreen
import com.kazemieh.www.shop.ui.screens.productdetail.ProductDescriptionScreen
import com.kazemieh.www.shop.ui.screens.productdetail.ProductDetailScreen
import com.kazemieh.www.shop.ui.screens.productdetail.ProductTechnicalFeaturesScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.ProductDetail.route + "/{63b9f7ce06661704dc22228d}"
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

        composable(
            route = Screen.ProductDetail.route + "/{productId}",
            arguments = listOf(
                navArgument("productId") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                }
            )
        ) {

            it.arguments?.getString("productId")?.let { productId ->
                ProductDetailScreen(
                    navController = navController,
                    productId = productId
                )
            }
        }

        composable(
            route = Screen.ProductDescription.route + "/{description}",
            arguments = listOf(
                navArgument("description") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                }
            )
        ) {

            it.arguments?.getString("description")?.let { description ->
                ProductDescriptionScreen(
                    navController = navController,
                    description = description
                )
            }
        }

        composable(
            route = Screen.ProductTechnicalFeatures.route + "/{jsonString}",
            arguments = listOf(
                navArgument("jsonString") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                }
            )
        ) {

            it.arguments?.getString("jsonString")?.let { jsonString ->
                ProductTechnicalFeaturesScreen(
                    navController = navController,
                    jsonString = jsonString
                )
            }
        }


        composable(route = Screen.NewComment.route + "?productId={productId}?productName={productName}?imageUrl={imageUrl}",
            arguments = listOf(
                navArgument("productId") {
                    type = NavType.StringType
                    defaultValue = " "
                    nullable = true
                },
                navArgument("productName") {
                    type = NavType.StringType
                    defaultValue = " "
                    nullable = true
                },
                navArgument("imageUrl") {
                    type = NavType.StringType
                    defaultValue = " "
                    nullable = true
                }
            )
        ) {
            it.arguments?.getString("productId")?.let { productId ->
                it.arguments?.getString("productName")?.let { productName ->
                    it.arguments?.getString("imageUrl")?.let { imageUrl ->
                        NewCommentScreen(
                            navController = navController,
                            productId = productId,
                            productName = productName,
                            imageUrl = imageUrl
                        )
                    }
                }
            }


        }

        composable(route = Screen.AllComment.route + "/{productId}/{commentsCount}",
            arguments = listOf(
                navArgument("productId") {
                    type = NavType.StringType
                    defaultValue = " "
                    nullable = true
                },
                navArgument("commentsCount") {
                    type = NavType.StringType
                    defaultValue = " "
                    nullable = true
                }
            )
        ) {
            it.arguments!!.getString("productId")?.let { productId ->
                it.arguments!!.getString("commentsCount")?.let { commentsCount ->
                    AllProductCommentsScreen(
                        navController = navController,
                        productId = productId,
                        commentsCount = commentsCount
                    )
                }
            }

        }


    }
}