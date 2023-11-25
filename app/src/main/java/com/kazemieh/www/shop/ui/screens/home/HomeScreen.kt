package com.kazemieh.www.shop.ui.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.kazemieh.www.shop.util.Constants
import com.kazemieh.www.shop.util.LocaleUtils
import com.kazemieh.www.shop.viewmodel.HomeViewModel
import kotlinx.coroutines.launch

val HomeScreenTAG = "HomeScreen"


@Composable
fun HomeScreen(navController: NavHostController) {
    Home(navController = navController)
}


@Composable
fun Home(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    Log.d("TAG", "onCreate:1 ${Constants.USER_LANGUAGE}")
    LocaleUtils.setLocale(LocalContext.current, Constants.USER_LANGUAGE)
    LaunchedEffect(key1 = true) {
        refreshDataFromServer(viewModel)
    }
    SwipeRefreshSection(viewModel = viewModel, navController = navController)

}


@Composable
fun SwipeRefreshSection(viewModel: HomeViewModel, navController: NavHostController) {
    val refreshScope = rememberCoroutineScope()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = false)
    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = {
            refreshScope.launch {
                Log.d(HomeScreenTAG, "Home: SwiperRefresh")
                refreshDataFromServer(viewModel)
            }
        }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp)
        ) {
            item { SearchBarSection() }
            item { TopSliderSection() }
            item { ShowCaseSection(navController) }
            item { AmazingOfferSection(navController) }
            item { ProposalCardSection(navController) }
            item { SuperMarketOfferSection(navController) }
            item { CategoryListSection(navController) }
            item { CenterBannerSection(1) }
            item { BestSellerOfferSection() }
            item { CenterBannerSection(2) }
            item { MostVisitedOfferSection() }
            item { CenterBannerSection(3) }
            item { MostFavoriteProductSection() }
            item { CenterBannerSection(4) }
            item { MostDiscountedSection() }
            item { CenterBannerSection(5) }

        }

    }
}


private suspend fun refreshDataFromServer(viewModel: HomeViewModel) {
    viewModel.getAllDataFromServer()
}