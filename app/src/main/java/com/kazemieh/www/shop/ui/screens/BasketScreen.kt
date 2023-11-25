package com.kazemieh.www.shop.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kazemieh.www.shop.ui.theme.selectedBottomBar
import com.kazemieh.www.shop.util.Constants

@Composable
fun BasketScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background( if (isSystemInDarkTheme()) Color.DarkGray else Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = Constants.USER_LANGUAGE,
            color = MaterialTheme.colorScheme.selectedBottomBar
        )

        Spacer(modifier = Modifier.size(20.dp))

    }
}


@Composable
fun BasketLight() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = Constants.USER_LANGUAGE,
            color = MaterialTheme.colorScheme.selectedBottomBar
        )

        Spacer(modifier = Modifier.size(20.dp))

    }
}


@Composable
fun BasketDark() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = Constants.USER_LANGUAGE,
            color = MaterialTheme.colorScheme.selectedBottomBar
        )

        Spacer(modifier = Modifier.size(20.dp))

    }
}

@Preview
@Composable
fun BasketLightPreView() {
    BasketLight()
}

@Preview
@Composable
fun BasketDarkPreView() {
    BasketDark()
}