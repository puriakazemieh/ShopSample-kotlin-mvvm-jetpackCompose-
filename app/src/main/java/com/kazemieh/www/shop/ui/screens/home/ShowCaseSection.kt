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
                    url = "https://www.kazemieh.com"
//                    url = "https://www.digikalajet.com/user/address"
                )
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.auction),
                title = stringResource(id = R.string.digi_style),
                onClick = onBoxClick(
                    navController = navController,
                    url = "https://www.digistyle.com/sale-landing/?utm_source=digikala&utm_medium=circle_badge&utm_campaign=style&promo_name=style&promo_position=circle_badge"
                )
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.digipay),
                title = stringResource(id = R.string.digi_pay),
                onClick = onBoxClick(
                    navController,
                    url = "https://www.digikala.com/my-digipay/?promo_name=my-digipay&promo_position=circle_badge"
                ),
            )

            RoundedIconBox(
                image = painterResource(id = R.drawable.pindo),
                title = stringResource(id = R.string.pindo),
                bgColor = MaterialTheme.colorScheme.amber,
                onClick = onBoxClick(
                    navController,
                    url = "https://www.pindo.ir/?utm_source=digikala&utm_medium=circle_badge&utm_campaign=pindo&promo_name=pindo&promo_position=circle_badge"
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
                    url = "https://www.digikala.com/landing/gift-card-landing/?promo_name=gift_landing&promo_position=circle_badge"
                ),

                )
            RoundedIconBox(
                image = painterResource(id = R.drawable.giftcard),
                title = stringResource(id = R.string.gift_card),
                onClick = {}
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.digiplus),
                title = stringResource(id = R.string.digi_plus),
                onClick = onBoxClick(
                    navController,
                    url = "https://www.digikala.com/plus/landing/?promo_name=plus&promo_position=circle_badge"
                ),
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.more),
                title = stringResource(id = R.string.more),
                bgColor = MaterialTheme.colorScheme.grayCategory,
                onClick = {}
            )

        }
    }
}


@Composable
fun onBoxClick(navController: NavController, url: String): () -> Unit =
    { navController.navigate(route = Screen.WebView.route + "?url=${url}") }