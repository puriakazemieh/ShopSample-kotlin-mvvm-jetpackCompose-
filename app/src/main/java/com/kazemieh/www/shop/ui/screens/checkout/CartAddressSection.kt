package com.kazemieh.www.shop.ui.screens.checkout

import android.util.Log
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.kazemieh.www.shop.data.model.address.UserAddress
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.ui.component.OurLoading
import com.kazemieh.www.shop.ui.theme.LightCyan
import com.kazemieh.www.shop.ui.theme.createIndication
import com.kazemieh.www.shop.ui.theme.createMutableInteractionSource
import com.kazemieh.www.shop.viewmodel.AddressViewModel

@Composable
fun CartAddressSection(
    navController: NavController,
    viewModel: AddressViewModel = hiltViewModel(),
    onAddressReady: (List<UserAddress>) -> Unit
) {
    var addressList by remember {
        mutableStateOf<List<UserAddress>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }


    var address = stringResource(id = R.string.no_address)
    var addressName = ""
    var addressBtnText = stringResource(id = R.string.add_address)

    val addressListResult by viewModel.userAddressList.collectAsState()
    when (addressListResult) {
        is NetworkResult.Success -> {
            addressList = addressListResult.data ?: emptyList()
            if (addressList.isNotEmpty()) {
                onAddressReady(addressList)
                address = addressList[0].address
                addressBtnText = stringResource(id = R.string.change_address)
                addressName = addressList[0].name
            }
            loading = false
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "CartAddressSection error : ${addressListResult.message}")
        }

        is NetworkResult.Loading -> {
            loading = true
        }
    }


    if (loading) {
        OurLoading(height = 135.dp, isDark = true)
    } else {
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
                Text(text = addressName)

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
                            addressBtnText,
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
}