package com.kazemieh.www.shop.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.kazemieh.www.shop.R

@Composable
fun Loading3Dots(isDark: Boolean) {
    val composition by  if (isDark) {
       rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.loading3dotsdark))
    } else {
        rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.loading3dots))
    }
    LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever)
}