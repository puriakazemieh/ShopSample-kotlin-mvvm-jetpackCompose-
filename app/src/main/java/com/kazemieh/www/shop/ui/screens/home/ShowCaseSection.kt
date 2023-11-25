package com.kazemieh.www.shop.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.navigation.Screen
import com.kazemieh.www.shop.ui.theme.LocalSpacing
import com.kazemieh.www.shop.ui.theme.RoundedIconBox
import com.kazemieh.www.shop.ui.theme.amber
import com.kazemieh.www.shop.ui.theme.grayCategory
import com.kazemieh.www.shop.util.Constants.AUCTION_URL
import com.kazemieh.www.shop.util.Constants.DIGIJET_URL
import com.kazemieh.www.shop.util.Constants.DIGIPAY_URL
import com.kazemieh.www.shop.util.Constants.DIGIPLUS_URL
import com.kazemieh.www.shop.util.Constants.GIFT_CARD_URL
import com.kazemieh.www.shop.util.Constants.MORE_URL
import com.kazemieh.www.shop.util.Constants.PINDO_URL
import com.kazemieh.www.shop.util.Constants.SHOPPING_URL

@Composable
fun ShowCaseSection(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = LocalSpacing.current.semiMedium,
                vertical = LocalSpacing.current.biggerSmall
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = LocalSpacing.current.semiSmall)
        ) {
            RoundedIconBox(
                image = painterResource(id = R.drawable.digijet),
                title = stringResource(id = R.string.my_shop_jet),
                onClick = onBoxClick(
                    navController = navController,
                    url = DIGIJET_URL
                )
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.auction),
                title = stringResource(id = R.string.digi_style),
                onClick = onBoxClick(
                    navController = navController,
                    url = AUCTION_URL
                )
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.digipay),
                title = stringResource(id = R.string.digi_pay),
                onClick = onBoxClick(
                    navController,
                    url = DIGIPAY_URL
                ),
            )

            RoundedIconBox(
                image = painterResource(id = R.drawable.pindo),
                title = stringResource(id = R.string.pindo),
                bgColor = MaterialTheme.colorScheme.amber,
                onClick = onBoxClick(
                    navController,
                    url = PINDO_URL
                ),
            )


        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = LocalSpacing.current.semiSmall)
        ) {
            RoundedIconBox(
                image = painterResource(id = R.drawable.shopping),
                title = stringResource(id = R.string.digi_shopping),
                onClick = onBoxClick(
                    navController,
                    url =SHOPPING_URL
                ),

                )
            RoundedIconBox(
                image = painterResource(id = R.drawable.giftcard),
                title = stringResource(id = R.string.gift_card),
                onClick =onBoxClick(
                    navController,
                    url = GIFT_CARD_URL
                )

            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.digiplus),
                title = stringResource(id = R.string.digi_plus),
                onClick = onBoxClick(
                    navController,
                    url = DIGIPLUS_URL
                ),
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.more),
                title = stringResource(id = R.string.more),
                bgColor = MaterialTheme.colorScheme.grayCategory,
                onClick =  onBoxClick(
                    navController,
                    url = MORE_URL
                )

            )

        }
    }
}


@Composable
fun onBoxClick(navController: NavController, url: String): () -> Unit =
    { navController.navigate(route = Screen.WebView.route + "?url=${url}") }