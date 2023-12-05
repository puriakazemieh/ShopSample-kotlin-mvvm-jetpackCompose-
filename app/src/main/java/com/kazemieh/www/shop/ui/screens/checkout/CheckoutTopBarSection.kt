package com.kazemieh.www.shop.ui.screens.checkout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.kazemieh.www.shop.R

@Composable
fun CheckoutTopBarSection(navController: NavController,) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        IconButton(onClick = { navController.popBackStack()}) {
            Icon(
                imageVector = Icons.Filled.ArrowForward,
                contentDescription = null,)
        }

        Text(text = stringResource(id = R.string.address_and_time))
    }
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .alpha(0.4f),
        color = Color.LightGray
    )
}