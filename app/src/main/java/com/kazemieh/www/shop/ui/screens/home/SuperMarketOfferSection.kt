package com.kazemieh.www.shop.ui.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.data.model.home.AmazingItem
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.ui.theme.LightGreen
import com.kazemieh.www.shop.ui.theme.LightRed
import com.kazemieh.www.shop.viewmodel.HomeViewModel

@Composable
fun SuperMarketOfferSection(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    var superMarketItemList by remember {
        mutableStateOf<List<AmazingItem>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }

    val superMarketItemResult by viewModel.amazingSuperMarketItems.collectAsState()
    when (superMarketItemResult) {
        is NetworkResult.Success -> {
            superMarketItemList = superMarketItemResult.data ?: emptyList()
            loading = false
            Log.d("TAG", "superMarketItemResult: $superMarketItemList")
        }

        is NetworkResult.Error -> {
            loading = false
            Log.d("TAG", "superMarketItemResult: ${superMarketItemResult.message} ")
        }

        is NetworkResult.Loading -> {
            loading = true
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.LightGreen)
    ) {

        LazyRow(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.LightGreen)
        ) {
            item { AmazingOfferCard(R.drawable.supermarketamazings, R.drawable.fresh) }

            items(superMarketItemList){
                AmazingOfferItem(it)
            }
            item { AmazingShowMore() }
        }

    }
}