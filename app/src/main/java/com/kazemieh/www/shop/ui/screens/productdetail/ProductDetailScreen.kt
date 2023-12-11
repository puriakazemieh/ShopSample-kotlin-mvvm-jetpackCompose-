package com.kazemieh.www.shop.ui.screens.productdetail

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kazemieh.www.shop.data.model.productdetail.Comment
import com.kazemieh.www.shop.data.model.productdetail.ProductDetail
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.ui.component.OurLoading
import com.kazemieh.www.shop.ui.theme.spacing
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

    var description by remember { mutableStateOf("") }
    var technicalFeatures by remember { mutableStateOf("") }
    var commentCount by remember { mutableStateOf(0) }
    var productComments by remember {
        mutableStateOf<List<Comment>>(emptyList())
    }


    LaunchedEffect(true) {
        viewModel.getProductById(productId)
        viewModel.productDetail.collectLatest { productDetail ->
            when (productDetail) {
                is NetworkResult.Success -> {
                    productDetailList = productDetail.data ?: ProductDetail()
                    description = productDetail.data?.description ?: ""
                    technicalFeatures = productDetail.data?.technicalFeatures.toString()
                    productComments = productDetail.data?.comments ?: emptyList()
                    commentCount = productDetail.data?.commentCount ?: 0

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

    if (loading) {
        val config = LocalConfiguration.current
        OurLoading(height = config.screenHeightDp.dp, isDark = true)
    } else {
        Scaffold(
            bottomBar = {
                ProductDetailBottomBar(item = productDetailList, navController = navController)
            }
        ) {
            LazyColumn() {
                item { productDetailList.imageSlider?.let { it1 -> ProductTopSliderSection(it1) } }
                item { ProductDetailHeaderSection(productDetailList) }
                item { productDetailList.colors?.let { it1 -> ProductSelectColorSection(it1) } }
                item { SellerInfoSection() }
                item { productDetailList.categoryId?.let { it1 -> SimilarProductSection(it1) } }
                item { ProductDescriptionSection(navController, description, technicalFeatures) }
                item { ProductCommentsSection(productComments, commentCount) }
                item { Text(text = productId) }

                item { Spacer(modifier = Modifier.height(80.dp)) }
            }
        }
    }


}