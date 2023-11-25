package com.kazemieh.www.shop.ui.screens.home

import android.util.DisplayMetrics
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.kazemieh.www.shop.data.model.home.Slider
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.ui.component.OurLoading
import com.kazemieh.www.shop.ui.theme.LocalShape
import com.kazemieh.www.shop.ui.theme.LocalSpacing
import com.kazemieh.www.shop.viewmodel.HomeViewModel
import kotlinx.coroutines.delay


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopSliderSection(viewModel: HomeViewModel = hiltViewModel()) {


    var sliderList by remember {
        mutableStateOf<List<Slider>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }


    val sliderResult by viewModel.slider.collectAsState()
    when (sliderResult) {
        is NetworkResult.Success -> {
            loading = false
            sliderList = sliderResult.data ?: emptyList()
        }

        is NetworkResult.Error -> {
            loading = false
            Log.d(HomeScreenTAG, "TopSlider: Error ${sliderResult.message}")
        }

        is NetworkResult.Loading -> {
            loading = true
        }
    }

    val configuration = LocalConfiguration.current
    val widthInDp = configuration.screenWidthDp.dp
    val heightInDp = configuration.screenHeightDp.dp


    if (loading) {
        OurLoading(heightInDp, true)
    } else {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {

            Box(modifier = Modifier.fillMaxWidth()) {

                val pagerState = rememberPagerState(pageCount = { sliderList.size })
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(
                            horizontal = LocalSpacing.current.extraSmall,
                            vertical = LocalSpacing.current.small
                        )
                ) {

                    var imageUrl by remember { mutableStateOf("") }

                    HorizontalPager(
                        state = pagerState,
                        contentPadding = PaddingValues(horizontal = LocalSpacing.current.medium),
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    ) { page ->

                        imageUrl = sliderList[page].image
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            val painter = rememberAsyncImagePainter(
                                ImageRequest.Builder(LocalContext.current)
                                    .data(data = imageUrl)
                                    .apply(
                                        block = fun ImageRequest.Builder.() {
                                            scale(Scale.FILL)
                                        }
                                    )
                                    .build()
                            )

                            Image(
                                painter = painter,//painterResource(id = R.drawable.digi_logo),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(LocalSpacing.current.small)
                                    .clip(LocalShape.current.medium)
                                    .fillMaxSize(),
                                contentScale = ContentScale.FillBounds
                            )

                        }

                    }

                }

                LazyRow(
//                contentPadding = PaddingValues(vertical = LocaleSpacing.current.semiLarge),
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(LocalSpacing.current.semiLarge),
                ) {
                    items(sliderList.size) {
                        Box(
                            modifier = Modifier
                                .padding(LocalSpacing.current.semiExtraSmall)
                                .fillMaxWidth()
                                .wrapContentWidth(Alignment.CenterHorizontally)
                                .wrapContentHeight(Alignment.CenterVertically)
                                .clip(CircleShape)
                                .size(
                                    width = LocalSpacing.current.small,
                                    height = LocalSpacing.current.small
                                )
                                .background(color = if (it == pagerState.currentPage) Color.Black else Color.LightGray)
                        )
                    }
                }


                LaunchedEffect(key1 = pagerState.currentPage) {
                    delay(6000)
                    var newPosition = pagerState.currentPage + 1
                    if (newPosition > sliderList.size - 1) newPosition = 0
                    pagerState.scrollToPage(newPosition)
                }

            }
        }
    }
}
