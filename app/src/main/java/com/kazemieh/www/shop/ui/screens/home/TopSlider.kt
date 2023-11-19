package com.kazemieh.www.shop.ui.screens.home

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.kazemieh.www.shop.data.model.home.Slider
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun TopSlider(viewModel: HomeViewModel = hiltViewModel()) {


    var list by remember {
        mutableStateOf<List<Slider>>(emptyList())
    }
    
    var loading by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = true) {
        viewModel.slider.collectLatest { result ->
            when (result) {
                is NetworkResult.Success -> {
                    result.data?.let {
                        list = it
                        Log.d(HomeScreenTAG, "TopSlider: list ${list}")
                    }
                }

                is NetworkResult.Error -> {
                    loading = false
                    Log.d(HomeScreenTAG, "TopSlider: Error ${result.message}")
                }

                is NetworkResult.Loading -> {
                    loading = true
                }
            }
        }
    }
}
