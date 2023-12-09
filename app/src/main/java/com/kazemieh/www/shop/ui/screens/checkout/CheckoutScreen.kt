package com.kazemieh.www.shop.ui.screens.checkout

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kazemieh.www.shop.data.model.chekcout.OrderDetail
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.navigation.Screen
import com.kazemieh.www.shop.ui.screens.basket.BuyProcessContinue
import com.kazemieh.www.shop.ui.screens.basket.CartPriceDetailSection
import com.kazemieh.www.shop.util.Constants.USER_TOKEN
import com.kazemieh.www.shop.util.navigationBarHeight
import com.kazemieh.www.shop.viewmodel.BasketViewModel
import com.kazemieh.www.shop.viewmodel.CheckoutViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest


@Composable
fun CheckoutScreen(navController: NavController) {
    Checkout(navController)
}

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Checkout(
    navController: NavController,
    basketViewModel: BasketViewModel = hiltViewModel(),
    checkoutViewModel: CheckoutViewModel = hiltViewModel()

) {

    val cartDetail by basketViewModel.cartDetail.collectAsState()
    val currentCartItems by basketViewModel.ourCartItems.collectAsState()

    var shippingCost by remember { mutableStateOf(0) }
    var loading by remember { mutableStateOf(false) }
    var address by remember { mutableStateOf("") }
    var addressName by remember { mutableStateOf("") }
    var addressPhone by remember { mutableStateOf("") }


    // todo    این api چندین بار کال میشه که باید جلوش گرفته بشه و اینکه با اون url قدیمی نمیشه کار کرد چون ارور برمی گردونه

    LaunchedEffect(key1 = true) {
        if (address.isNotBlank())
            checkoutViewModel.getShippingCost(address)
        else checkoutViewModel.getShippingCost("")
    }

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

    var orderId by remember { mutableStateOf("") }

//    val orderIdResult by checkoutViewModel.orderResponse.collectAsState()
    LaunchedEffect(key1 = Dispatchers.Main) {
        checkoutViewModel.orderResponse.collectLatest { orderIdResult ->

            when (orderIdResult) {
                is NetworkResult.Success -> {
                    orderId = orderIdResult.data ?: ""
                    navController.navigate(
                        Screen.ConfirmPurchase.withArgs(
                            orderId,
                            cartDetail.payablePrice + shippingCost
                        )
                    )
                }

                is NetworkResult.Error -> {}

                is NetworkResult.Loading -> {}
            }
        }
    }


    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState =
        rememberStandardBottomSheetState(initialValue = SheetValue.Hidden, skipHiddenState = false)
    val scaffoldState = rememberBottomSheetScaffoldState(sheetState)
//    BottomSheetScaffold(
//        scaffoldState = scaffoldState,
//        sheetDragHandle = {},
////        sheetPeekHeight = 128.dp, // height of the bottom sheet in the collapsed state
//        sheetContent = {
//            DeliveryTimeBottomSheet()
//        }) {

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
                        if (it.isNotEmpty()) {
                            address = it[0].address
                            addressName = it[0].name
                            addressPhone = it[0].phone
                        }
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
                item {
                    CartItemReviewSection(cartDetail, currentCartItems) {
                        showBottomSheet = !showBottomSheet
//                            scope.launch {
//                                scaffoldState.bottomSheetState.expand()
//                            }
                    }
                }
                item { CartInfoSection() }
                item {
                    CartPriceDetailSection(
                        cartDetails = cartDetail,
                        shippingCost = shippingCost
                    )
                }
            }

            // Sheet content
            if (showBottomSheet) {
                val windowInsets = WindowInsets(bottom = LocalContext.current.navigationBarHeight())
                ModalBottomSheet(
                    onDismissRequest = { showBottomSheet = false },
                    sheetState = sheetState,
                    content = { DeliveryTimeBottomSheet() },
                    dragHandle = {},
                    windowInsets = windowInsets
                )
            }
            if (!loading) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BuyProcessContinue(cartDetail.payablePrice, shippingCost) {
                        checkoutViewModel.addNewOrder(
                            OrderDetail(
                                orderAddress = address,
                                orderProducts = currentCartItems,
                                orderTotalDiscount = cartDetail.totalDiscount,
                                orderTotalPrice = cartDetail.payablePrice + shippingCost,
                                orderUserName = addressName,
                                orderUserPhone = addressPhone,
                                token = USER_TOKEN
                            )
                        )
                    }

                }
            }

        }


    }
//    }

}
