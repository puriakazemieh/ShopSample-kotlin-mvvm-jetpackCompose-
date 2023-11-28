package com.kazemieh.www.shop.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)



val ColorScheme.splashBg: Color
    @Composable
    get() = Color(0xFFed1b34)


val ColorScheme.selectedBottomBar: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF43474c) else Color(0xFFCFD4DA)

val ColorScheme.unSelectedBottomBar: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFFCFD4DA) else Color(0xFF43474c)


val ColorScheme.searchBarBg: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF303235) else Color(0xFFF1F0EE)


val ColorScheme.darkText: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFFD8D8D8) else Color(0xFF414244)


val ColorScheme.amber: Color
    @Composable
    get() =  Color(0xffFFBF00)


val ColorScheme.grayCategory: Color
    @Composable
    get() = Color(0xFFF1F0EE)


val ColorScheme.LightRed: Color
    @Composable
    get() = Color(0xffef4056)

val ColorScheme.DarkRed: Color
    @Composable
    get() = Color(0xFFe6123d)


val ColorScheme.semiDarkText: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFFD8D8D8) else Color(0xFF5C5E61)


val ColorScheme.cardBackground: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF1B1A1A) else Color(0xFFFAFAFA)


val ColorScheme.DarkCyan: Color
    @Composable
    get() = Color(0xFF0fabc6)



val ColorScheme.LightCyan: Color
    @Composable
    get() = Color(0xFF17BFD3)

val ColorScheme.LightGreen: Color
    @Composable
    get() = Color(0xff86bf3c)
