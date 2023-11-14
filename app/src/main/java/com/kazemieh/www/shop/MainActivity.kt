package com.kazemieh.www.shop

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kazemieh.www.shop.navigation.SetupNavGraph
import com.kazemieh.www.shop.ui.theme.ShopTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShopTheme {
                navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        // todo bottom bar
                    }
                ) {
                    SetupNavGraph(navController = navController)
                }


            }
        }
    }
}
