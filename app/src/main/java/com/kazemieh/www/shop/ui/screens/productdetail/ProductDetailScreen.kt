package com.kazemieh.www.shop.ui.screens.productdetail

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kazemieh.www.shop.data.model.productdetail.ProductDetail
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.viewmodel.ProductDetailViewModel
import kotlinx.coroutines.flow.collectLatest

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductDetailScreen(
    navController: NavController,
    productId: String = "63b9f7ce06661704dc22228d",
    viewModel: ProductDetailViewModel = hiltViewModel()
) {
    val productId = "63b9f7ce06661704dc22228d"

    Text(text = productId)
    Log.d("949494", "productId=$productId")
    var productDetailList by remember {
        mutableStateOf(ProductDetail())
    }
    var loading by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(true) {
        viewModel.getProductById(productId)
        viewModel.productDetail.collectLatest { productDetail ->
            when (productDetail) {
                is NetworkResult.Success -> {
                    productDetailList = productDetail.data!!
                    productDetailList.name?.let { Log.d("949494", it) }
                    loading = false
                }

                is NetworkResult.Error -> {
                    loading = false
                    Log.d("949494", "ProductDetailScreen error : ${productDetail.message}")
                }

                is NetworkResult.Loading -> {
                    loading = true
                }
            }
        }

    }


    Scaffold(
        bottomBar = {
            ProductDetailBottomBar(item = productDetailList, navController = navController)
        }
    ) {
        LazyColumn() {
            item {
                Text(text = productId)
            }
        }
    }


}