package com.kazemieh.www.shop.ui.screens.basket

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.data.model.home.StoreProduct
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.ui.screens.home.MostDiscountedCard
import com.kazemieh.www.shop.ui.theme.darkText
import com.kazemieh.www.shop.ui.theme.searchBarBg
import com.kazemieh.www.shop.ui.theme.spacing
import com.kazemieh.www.shop.viewmodel.BasketViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SuggestListSection(
    viewModel: BasketViewModel = hiltViewModel()
) {
    viewModel.getSuggestedItems()

    var suggestedList by remember {
        mutableStateOf<List<StoreProduct>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }

    val suggestedItemResult by viewModel.suggestedList.collectAsState()
    when (suggestedItemResult) {
        is NetworkResult.Success -> {
            suggestedList = suggestedItemResult.data ?: emptyList()
            loading = false
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "SuggestListSection error : ${suggestedItemResult.message}")
        }

        is NetworkResult.Loading -> {
            loading = true
        }
    }

    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(MaterialTheme.spacing.small)
            .background(MaterialTheme.colorScheme.searchBarBg)
    )
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.medium),
        text = stringResource(id = R.string.suggestion_for_you),
        textAlign = TextAlign.Right,
        style = MaterialTheme.typography.titleSmall,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colorScheme.darkText,
    )

    FlowRow(
        maxItemsInEachRow = 2,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.Start
    ) {
        suggestedList.forEach {
            MostDiscountedCard(it)
        }
    }


}