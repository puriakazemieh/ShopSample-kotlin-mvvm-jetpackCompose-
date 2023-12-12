package com.kazemieh.www.shop.ui.screens.productdetail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController


@Composable
fun AllProductCommentsScreen(
    navController: NavHostController,
    productId: String
) {
    Text(text = productId)
}