package com.kazemieh.www.shop.ui.screens.basket

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.data.model.basket.CartItem
import com.kazemieh.www.shop.data.model.basket.CartStatus
import com.kazemieh.www.shop.ui.theme.darkText
import com.kazemieh.www.shop.ui.theme.spacing
import com.kazemieh.www.shop.util.Constants
import com.kazemieh.www.shop.util.Constants.USER_TOKEN
import com.kazemieh.www.shop.viewmodel.BasketViewModel

@Composable
fun NextShoppingList(
    navController: NavController,
    viewModel: BasketViewModel = hiltViewModel()
) {
    val nextCartItemsState: BasketScreenState<List<CartItem>> by viewModel.nextCartItems.collectAsState(
        BasketScreenState.Loading
    )

//    val nextCartItems = remember {
//        mutableStateOf(emptyList<CartItem>())
//    }
//
//    LaunchedEffect(key1 = true) {
//        viewModel.nextCartItems.collectLatest {
//            nextCartItems.value = it
//        }
//
//    }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 80.dp)
    ) {

        Log.d("TAG", "NextShoppingList: $USER_TOKEN")
        item {
            if (USER_TOKEN == "null") {
                LoginOrRegisterSection(navController)
            }
        }

        when(nextCartItemsState){
            is BasketScreenState.Loading->{
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
            is BasketScreenState.Success->{
                if ((nextCartItemsState as BasketScreenState.Success<List<CartItem>>).data.isEmpty()) {
                    item { EmptyNextBasketShopping() }
                } else {
                    items((nextCartItemsState as BasketScreenState.Success<List<CartItem>>).data) {
                        CartItemCard(it, CartStatus.NEXT_CART)
                    }
                }
            }
            is BasketScreenState.Error->{}
        }



    }
}