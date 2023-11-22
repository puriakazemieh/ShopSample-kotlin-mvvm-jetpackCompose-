package com.kazemieh.www.shop.ui.screens.home

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kazemieh.www.shop.data.model.home.AmazingItem
import com.kazemieh.www.shop.data.remote.NetworkResult
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

}