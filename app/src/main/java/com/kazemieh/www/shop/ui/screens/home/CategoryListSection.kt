package com.kazemieh.www.shop.ui.screens.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.data.model.home.MainCategory
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.ui.theme.darkText
import com.kazemieh.www.shop.ui.theme.spacing
import com.kazemieh.www.shop.viewmodel.HomeViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CategoryListSection(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    var categoryList by remember {
        mutableStateOf<List<MainCategory>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }

    val categoryResult by viewModel.categories.collectAsState()
    when (categoryResult) {
        is NetworkResult.Success -> {
            categoryList = categoryResult.data ?: emptyList()
            loading = false
            Log.d("TAG", "AmazingOfferSection: $categoryList")
        }

        is NetworkResult.Error -> {
            loading = false
            Log.d("TAG", "AmazingOfferSection: ${categoryResult.message} ")
        }

        is NetworkResult.Loading -> {
            loading = true
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.small)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = MaterialTheme.spacing.medium),
            text = stringResource(id = R.string.category_title),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.darkText
        )

        FlowRow(
            horizontalArrangement = Arrangement.SpaceAround,
            maxItemsInEachRow = 3,
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.small)
        ) {

            categoryList.forEach {
                CircularCategoryItem(item = it)
            }
        }
    }
}

@Composable
fun CircularCategoryItem(item: MainCategory) {

    Column(
        modifier = Modifier
            .size(100.dp, 160.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Image(
            painter = rememberAsyncImagePainter(model = item.image),
            contentDescription = "",
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .padding(vertical = MaterialTheme.spacing.extraSmall)
        )
        Text(
            text = item.name,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = MaterialTheme.spacing.extraSmall),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.darkText,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }


}