package com.kazemieh.www.shop.ui.screens.checkout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.ui.theme.Oranges
import com.kazemieh.www.shop.ui.theme.spacing
import com.kazemieh.www.shop.util.DigitHelper.digitByLocate

@Composable
fun DeliveryTimeBottomSheet() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
             RadioButton(selected = true, onClick = { /*TODO*/ }) 
             Text(text =  stringResource(id = R.string.pishtaz_post))
            }
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id =R.drawable.digi_plus_icon),
                    contentDescription = "",
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = digitByLocate(stringResource(id =R.string.delivery_delay)),
                    color = MaterialTheme.colorScheme.Oranges,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(horizontal = MaterialTheme.spacing.medium),
                )
            }

        }

    }
}