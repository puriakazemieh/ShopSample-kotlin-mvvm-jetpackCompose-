package com.kazemieh.www.shop.ui.screens.category

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.kazemieh.www.shop.ui.screens.home.AmazingOfferSection
import com.kazemieh.www.shop.ui.screens.home.BestSellerOfferSection
import com.kazemieh.www.shop.ui.screens.home.CategoryListSection
import com.kazemieh.www.shop.ui.screens.home.CenterBannerSection
import com.kazemieh.www.shop.ui.screens.home.HomeScreenTAG
import com.kazemieh.www.shop.ui.screens.home.MostDiscountedSection
import com.kazemieh.www.shop.ui.screens.home.MostFavoriteProductSection
import com.kazemieh.www.shop.ui.screens.home.MostVisitedOfferSection
import com.kazemieh.www.shop.ui.screens.home.ProposalCardSection
import com.kazemieh.www.shop.ui.screens.home.SearchBarSection
import com.kazemieh.www.shop.ui.screens.home.ShowCaseSection
import com.kazemieh.www.shop.ui.screens.home.SuperMarketOfferSection
import com.kazemieh.www.shop.ui.screens.home.TopSliderSection
import com.kazemieh.www.shop.viewmodel.CategoryViewModel
import com.kazemieh.www.shop.viewmodel.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun CategoryScreen(navController: NavHostController) {
    Category(navController = navController)
}

@Composable
fun Category(
    navController: NavHostController,
    viewModel: CategoryViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = true) {
        refreshDataFromServer(viewModel)

    }

    SwipeRefreshSection(viewModel = viewModel, navController = navController)

}

@Composable
private fun SwipeRefreshSection(viewModel: CategoryViewModel, navController: NavHostController) {
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
            item { SubCategorySection() }


        }

    }
}


private suspend fun refreshDataFromServer(viewModel: CategoryViewModel) {
    viewModel.getAllDataFromServer()
}