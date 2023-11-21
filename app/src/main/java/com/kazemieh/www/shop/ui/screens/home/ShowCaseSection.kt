package com.kazemieh.www.shop.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.ui.theme.LocalShape
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
                onClick = {}
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.auction),
                title = stringResource(id = R.string.digi_style),
                onClick = {}
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.digipay),
                title = stringResource(id = R.string.digi_pay),
                onClick = {}
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.pindo),
                title = stringResource(id = R.string.pindo),
                bgColor = MaterialTheme.colorScheme.amber,
                onClick = {}
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
                onClick = {}
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.giftcard),
                title = stringResource(id = R.string.gift_card),
                onClick = {}
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.digiplus),
                title = stringResource(id = R.string.digi_plus),
                onClick = {}
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

