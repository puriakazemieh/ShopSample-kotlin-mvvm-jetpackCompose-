package com.kazemieh.www.shop.ui.screens.checkout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CheckoutScreen(navController: NavController) {
    Checkout(navController)
}

@Composable
fun Checkout(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CheckoutTopBarSection(navController)
        LazyColumn {
            item { CartAddressSection(navController) }
            item {
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .alpha(0.4f),
                    color = Color.LightGray
                )
            }
        }
    }
}
