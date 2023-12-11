package com.kazemieh.www.shop.ui.screens.productdetail

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.data.model.home.StoreProduct
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.ui.screens.home.MostFavoriteProductsOffer
import com.kazemieh.www.shop.ui.screens.home.MostFavoriteProductsShowMore
import com.kazemieh.www.shop.ui.theme.darkText
import com.kazemieh.www.shop.ui.theme.spacing
import com.kazemieh.www.shop.viewmodel.ProductDetailViewModel
import kotlinx.coroutines.flow.collectLatest


@Composable
fun SimilarProductSection(
    categoryId: String,
    viewModel: ProductDetailViewModel = hiltViewModel()
) {

    var similarList by remember {
        mutableStateOf<List<StoreProduct>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(true) {
        viewModel.getSimilarProducts(categoryId)
        viewModel.similarProducts.collectLatest { similarListResult ->
            when (similarListResult) {
                is NetworkResult.Success -> {
                    similarList = similarListResult.data ?: emptyList()
                    loading = false
                }
                is NetworkResult.Error -> {
                    loading = false
                    Log.e("3636", "SimilarProductSection error : ${similarListResult.message}")
                }
                is NetworkResult.Loading -> {
                    loading = true
                }
            }
        }

    }


    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .height(MaterialTheme.spacing.small)
            .alpha(0.4f)
            .shadow(2.dp),
        color = Color.LightGray,
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.spacing.small)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = MaterialTheme.spacing.extraSmall),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = stringResource(id = R.string.similar_product),
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.darkText,
            )

        }


        LazyRow {
            items(similarList) { item ->
                MostFavoriteProductsOffer(item)
            }
            item {
                MostFavoriteProductsShowMore()
            }
        }

    }


}