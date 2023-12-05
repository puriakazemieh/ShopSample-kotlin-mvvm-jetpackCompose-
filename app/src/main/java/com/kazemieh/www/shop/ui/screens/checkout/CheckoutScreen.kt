package com.kazemieh.www.shop.ui.screens.checkout

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.ui.screens.basket.BuyProcessContinue
import com.kazemieh.www.shop.ui.screens.basket.CartPriceDetailSection
import com.kazemieh.www.shop.viewmodel.BasketViewModel
import com.kazemieh.www.shop.viewmodel.CheckoutViewModel

@Composable
fun CheckoutScreen(navController: NavController) {
    Checkout(navController)
}

@Composable
fun Checkout(
    navController: NavController,
    basketViewModel: BasketViewModel = hiltViewModel(),
    checkoutViewModel: CheckoutViewModel = hiltViewModel()

) {

    val cartDetail by basketViewModel.cartDetail.collectAsState()
    val currentCartItems by basketViewModel.ourCartItems.collectAsState()

    var shippingCost by remember {
        mutableStateOf(0)
    }
    var loading by remember {
        mutableStateOf(false)
    }
    // todo    این api چندین بار کال میشه که باید جلوش گرفته بشه و اینکه با اون url قدیمی نمیشه کار کرد چون ارور برمی گردونه

    val shippingCostResult by checkoutViewModel.shippingCost.collectAsState()
    when (shippingCostResult) {
        is NetworkResult.Success -> {
            shippingCost = shippingCostResult.data ?: 0
            loading = false
        }

        is NetworkResult.Error -> {
            loading = false

        }

        is NetworkResult.Loading -> {
            loading = true
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CheckoutTopBarSection(navController)
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            LazyColumn {
                item {
                    CartAddressSection(navController) {
                        if (it.isNotEmpty())
                            checkoutViewModel.getShippingCost(it[0].address)
                        else checkoutViewModel.getShippingCost("")
                    }
                }
                item {
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(4.dp)
                            .alpha(0.4f),
                        color = Color.LightGray
                    )
                }
                item { CartItemReviewSection(shippingCost, cartDetail, currentCartItems) }
                item { CartInfoSection() }
                item {
                    CartPriceDetailSection(
                        cartDetails = cartDetail,
                        shippingCost = shippingCost
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BuyProcessContinue(cartDetail.payablePrice, shippingCost) {

                }

            }

        }


    }
}
