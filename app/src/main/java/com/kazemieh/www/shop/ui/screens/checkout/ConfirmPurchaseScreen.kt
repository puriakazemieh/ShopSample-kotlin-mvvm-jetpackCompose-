package com.kazemieh.www.shop.ui.screens.checkout

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.data.model.chekcout.ConfirmPurchase
import com.kazemieh.www.shop.navigation.Screen
import com.kazemieh.www.shop.ui.theme.LightRed
import com.kazemieh.www.shop.ui.theme.roundedShape
import com.kazemieh.www.shop.ui.theme.spacing
import com.kazemieh.www.shop.util.Constants.USER_TOKEN
import com.kazemieh.www.shop.util.DigitHelper
import com.kazemieh.www.shop.util.ZarinpalPurchase
import com.kazemieh.www.shop.viewmodel.BasketViewModel
import com.kazemieh.www.shop.viewmodel.CheckoutViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ConfirmPurchaseScreen(
    navController: NavController,
    orderId: String,
    orderPrice: String,
    basketViewModel: BasketViewModel = hiltViewModel(),
    checkoutViewModel: CheckoutViewModel= hiltViewModel()
) {
    val context = LocalContext.current
    val activity = context as Activity

    var orderState by remember {
        mutableStateOf(context.getString(R.string.waiting_for_purchase))
    }


    LaunchedEffect(key1 = true) {
        ZarinpalPurchase.fakePurchase(activity, orderPrice.toLong(), "خرید تستی") { transitionId ->
            orderState = context.getString(R.string.purchase_is_ok)
            basketViewModel.deleteAllItems()
            checkoutViewModel.confirmPurchase(
                ConfirmPurchase(
                    token = USER_TOKEN,
                    transactionId = transitionId,
                    orderId = orderId
                )
            )
            Log.d("949494", " transitionId = $transitionId ")
        }
    }




    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                MaterialTheme.spacing.medium,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.final_price),
                style = MaterialTheme.typography.labelSmall
            )

            Text(
                text = DigitHelper.digitByLocateAndSeparator(orderPrice),
                style = MaterialTheme.typography.titleSmall
            )
        }

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.order_status),
                style = MaterialTheme.typography.headlineLarge
            )

            Text(
                text = orderState,
                style = MaterialTheme.typography.headlineLarge
            )
        }

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.order_code),
                style = MaterialTheme.typography.bodySmall
            )

            Text(
                text = orderId,
                style = MaterialTheme.typography.headlineLarge
            )
        }

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

        Button(
            onClick = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Home.route) {
                        inclusive = true
                    }
                }
            },
            border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.LightRed),
            shape = MaterialTheme.roundedShape.small,
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text(
                modifier = Modifier
                    .padding(
                        MaterialTheme.spacing.small,
                    ),
                text = stringResource(id = R.string.return_to_home_page),
                color = MaterialTheme.colorScheme.LightRed,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
            )
        }

    }
}

