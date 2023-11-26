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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.data.model.home.AmazingItem
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.ui.theme.LightRed
import com.kazemieh.www.shop.util.Constants
import com.kazemieh.www.shop.viewmodel.HomeViewModel

@Composable
fun AmazingOfferSection(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    var amazingItemList by remember {
        mutableStateOf<List<AmazingItem>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }

    val amazingItemResult by viewModel.amazingItems.collectAsState()
    when (amazingItemResult) {
        is NetworkResult.Success -> {
            amazingItemList = amazingItemResult.data ?: emptyList()
            loading = false
            Log.d("TAG", "AmazingOfferSection: $amazingItemList")
        }

        is NetworkResult.Error -> {
            loading = false
            Log.d("TAG", "AmazingOfferSection: ${amazingItemResult.message} ")
        }

        is NetworkResult.Loading -> {
            loading = true
        }
    }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.LightRed)
    ) {

        LazyRow(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.LightRed)
        ) {
            item { AmazingOfferCard(R.drawable.amazings, R.drawable.box) }

            items(amazingItemList){
                AmazingOfferItem(it)
            }
            item { AmazingShowMore() }
        }

    }

}


