package com.kazemieh.www.shop.ui.screens.checkout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.ui.theme.LightCyan
import com.kazemieh.www.shop.ui.theme.createIndication
import com.kazemieh.www.shop.ui.theme.createMutableInteractionSource
import com.kazemieh.www.shop.viewmodel.AddressViewModel

@Composable
fun CartAddressSection(
    navController: NavController,
    viewModel: AddressViewModel = hiltViewModel()
) {

    val address= stringResource(id = R.string.no_address)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, bottom = 16.dp, top = 16.dp, end = 8.dp),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(id = R.drawable.location),
            contentDescription = null,
            modifier = Modifier
                .size(22.dp)
                .weight(0.15f)
                .align(Alignment.CenterVertically)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
//                .padding(start = 8.dp)
                .weight(0.85f)
        ) {
            Text(text = stringResource(id = R.string.send_to), color = Color.Gray)
            Text(text = address, maxLines = 3)
            Text(text = "address")

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center

            ) {
                Row(
                    modifier = Modifier
                        .clickable(
                            onClick = {

                            },
                            interactionSource = createMutableInteractionSource(),
                            indication = createIndication(
                                color = Color.Gray,
                                bounded = true
                            )
                        )
                        .padding(8.dp)
                ) {
                    Text(
                        text =
                        stringResource(id = R.string.save_to_next_list),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.LightCyan
                    )
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.LightCyan
                    )
                }
            }
        }
    }
}