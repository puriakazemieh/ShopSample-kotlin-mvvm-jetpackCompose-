package com.kazemieh.www.shop.ui.screens.basket

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.data.model.basket.CartItem
import com.kazemieh.www.shop.data.model.basket.CartStatus
import com.kazemieh.www.shop.ui.theme.darkText
import com.kazemieh.www.shop.ui.theme.spacing
import com.kazemieh.www.shop.util.Constants.USER_TOKEN
import com.kazemieh.www.shop.viewmodel.BasketViewModel

@Composable
fun ShoppingCart(
    navController: NavController,
    viewModel: BasketViewModel = hiltViewModel()
) {

    val currentCartItemsState: BasketScreenState<List<CartItem>> by viewModel.currentCartItems.collectAsState(
        BasketScreenState.Loading
    )

    val cartDetails = viewModel.cartDetail.collectAsState()

    var isCartEmpty by remember {
        mutableStateOf(true)
    }

//    val currentCartItem = remember {
//        mutableStateOf(emptyList<CartItem>())
//    }

//    LaunchedEffect(key1 = true) {
//        viewModel.currentCartItems.collectLatest {
//            currentCartItem.value = it
//        }
//    }


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(bottom = 80.dp)
        ) {

            item {
                if (USER_TOKEN == "null") {
                    LoginOrRegisterSection(navController)
                }
            }


            when (currentCartItemsState) {
                is BasketScreenState.Loading -> {
                    item {
                        Column(
                            modifier = Modifier
                                .height(LocalConfiguration.current.screenHeightDp.dp - 60.dp)
                                .fillMaxWidth()
                                .padding(vertical = MaterialTheme.spacing.small),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = stringResource(R.string.please_wait),
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.darkText,
                            )
                        }
                    }
                }

                is BasketScreenState.Success -> {
                    if ((currentCartItemsState as BasketScreenState.Success<List<CartItem>>).data.isEmpty()) {
                        isCartEmpty = true
                        item { EmptyBasketShopping() }
                        item { SuggestListSection() }
                    } else {
                        isCartEmpty = true
                        items((currentCartItemsState as BasketScreenState.Success<List<CartItem>>).data) {
                            CartItemCard(it, CartStatus.CURRENT_CART)
                        }
                        item {
                            CartPriceDetailSection(cartDetails = cartDetails.value)
                        }
                    }
                }

                is BasketScreenState.Error -> {}
            }


        }

        if (!isCartEmpty)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 80.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ByProcessContinue(cartDetails.value.payablePrice)
            }

    }
}