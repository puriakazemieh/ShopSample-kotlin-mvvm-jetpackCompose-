package com.kazemieh.www.shop.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.kazemieh.www.shop.R

val font_regular = FontFamily(
    Font(R.font.iran_yekan_mobile_regular)
)
val font_medium = FontFamily(
    Font(R.font.iran_yekan_mobile_medium)
)
val font_bold = FontFamily(
    Font(R.font.iran_yekan_mobile_bold)
)


val Typography.extraMediumNumber: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = font_medium,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 25.sp
    )

// Set of Material typography styles to start with
val Typography = Typography(

    displayLarge = TextStyle(
        fontFamily = font_regular,
        textAlign = TextAlign.Right
    ),
    displayMedium = TextStyle(
        fontFamily = font_regular,
        textAlign = TextAlign.Right
    ),
    displaySmall = TextStyle(
        fontFamily = font_regular,
        textAlign = TextAlign.Right
    ),

    headlineLarge = TextStyle(
        fontFamily = font_bold,
        textAlign = TextAlign.Right
    ),
    headlineMedium = TextStyle(
        fontFamily = font_bold,
        textAlign = TextAlign.Right
    ),
    headlineSmall = TextStyle(
        fontFamily = font_bold,
        textAlign = TextAlign.Right
    ),

    titleLarge = TextStyle(
        fontFamily = font_bold,
        textAlign = TextAlign.Right
    ),
    titleMedium = TextStyle(
        fontFamily = font_bold,
        textAlign = TextAlign.Right
    ),
    titleSmall = TextStyle(
        fontFamily = font_bold,
        textAlign = TextAlign.Right
    ),

    labelLarge = TextStyle(
        fontFamily = font_regular,
        textAlign = TextAlign.Right
    ),
    labelMedium = TextStyle(
        fontFamily = font_regular,
        textAlign = TextAlign.Right
    ),
    labelSmall = TextStyle(
        fontFamily = font_regular,
        textAlign = TextAlign.Right
    ),


    bodyLarge = TextStyle(
        fontFamily = font_regular,
        textAlign = TextAlign.Right
    ),
    bodyMedium = TextStyle(
        fontFamily = font_regular,
        textAlign = TextAlign.Right
    ),
    bodySmall = TextStyle(
        fontFamily = font_regular,
        textAlign = TextAlign.Right
    ),
)