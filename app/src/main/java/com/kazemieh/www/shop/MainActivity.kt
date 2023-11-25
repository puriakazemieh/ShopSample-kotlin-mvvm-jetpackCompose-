package com.kazemieh.www.shop

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
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
import com.kazemieh.www.shop.ui.component.AppConfig
import com.kazemieh.www.shop.ui.component.ChangeStatusBarColor
import com.kazemieh.www.shop.ui.theme.ShopTheme
import com.kazemieh.www.shop.util.Constants.ENGLISH_LANG
import com.kazemieh.www.shop.util.Constants.USER_LANGUAGE
import com.kazemieh.www.shop.util.LocaleUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity1"

    private lateinit var navController: NavHostController

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()

            ChangeStatusBarColor(navController = navController)
            ShopTheme {

                AppConfig()

                val direction =
                    if (USER_LANGUAGE == ENGLISH_LANG) LayoutDirection.Ltr else LayoutDirection.Rtl

                Log.d(TAG, "onCreate: $USER_LANGUAGE")

                LocaleUtils.setLocale(LocalContext.current, USER_LANGUAGE)
                CompositionLocalProvider(LocalLayoutDirection provides direction) {
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
