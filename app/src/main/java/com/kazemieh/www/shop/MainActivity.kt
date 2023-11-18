package com.kazemieh.www.shop

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kazemieh.www.shop.navigation.BottomNavigationBar
import com.kazemieh.www.shop.navigation.SetupNavGraph
import com.kazemieh.www.shop.ui.theme.ShopTheme
import com.kazemieh.www.shop.util.Constants.PERSIAN_LANG
import com.kazemieh.www.shop.util.LocaleUtils

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShopTheme {
                navController = rememberNavController()
                LocaleUtils.setLocale(LocalContext.current, PERSIAN_LANG)
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(
                                navController = navController,
                                onItemClick = {
                                    navController.navigate(it.route)
                                })
                        }
                    ) {
                        SetupNavGraph(navController = navController)
                    }
                }
            }
        }
    }
}
