package com.kazemieh.www.shop.ui.screens.basket

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ShoppingCart() {


    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 80.dp)
    ) {
        item { EmptyBasketShopping() }
        item { SuggestListSection() }
    }
}