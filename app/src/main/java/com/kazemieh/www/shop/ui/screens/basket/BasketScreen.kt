package com.kazemieh.www.shop.ui.screens.basket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontVariation.width
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.ui.theme.LightRed
import com.kazemieh.www.shop.ui.theme.spacing
import com.kazemieh.www.shop.viewmodel.BasketViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun BasketScreen(navController: NavHostController) {
    Basket(navController = navController)
}


@Composable
fun Basket(navController: NavHostController, viewModel: BasketViewModel = hiltViewModel()) {


    val currentCartItemCount = viewModel.currentCartItemCount.collectAsState(0)

    val nextCartItemCount = remember { mutableStateOf(0) }

    LaunchedEffect(key1 = true) {

        launch {
            viewModel.nextCartItemCount.collectLatest {
                nextCartItemCount.value = it
            }
        }

    }


    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    val tabTitles = listOf(
        stringResource(id = R.string.cart),
        stringResource(id = R.string.next_cart_list)
    )

    Column {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier
                .padding(
                    horizontal = MaterialTheme.spacing.medium
                ),
            contentColor = MaterialTheme.colorScheme.LightRed,
            indicator = {
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(it[selectedTabIndex])
                        .height(3.dp)
                        .background(Color.Red)
                )
            }
        ) {

            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = {
                        selectedTabIndex = index
                    },
                    selectedContentColor = MaterialTheme.colorScheme.LightRed,
                    unselectedContentColor = Color.Gray,
                    text = {
                        Row {
                            Text(
                                text = title,
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.SemiBold,
                            )
                            val cartCounter = if (index == 0) {
                                currentCartItemCount.value
                            } else {
                                nextCartItemCount.value
                            }

                            if (cartCounter > 0) {
                                Spacer(modifier = Modifier.width(10.dp))
                                SetBadgeToTap(
                                    selectedTabIndex = selectedTabIndex,
                                    index = index,
                                    cartCounter = cartCounter
                                )

                            }
                        }
                    }
                )
            }


        }

        when (selectedTabIndex) {
            0 -> ShoppingCart()
            1 -> NextShoppingList()
        }
    }


}

