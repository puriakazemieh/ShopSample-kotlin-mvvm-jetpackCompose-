package com.kazemieh.www.shop.ui.screens.productdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.ui.screens.basket.DetailRow
import com.kazemieh.www.shop.ui.theme.DarkCyan
import com.kazemieh.www.shop.ui.theme.LightGreen
import com.kazemieh.www.shop.ui.theme.LightRed
import com.kazemieh.www.shop.ui.theme.darkText
import com.kazemieh.www.shop.ui.theme.grayCategory
import com.kazemieh.www.shop.ui.theme.roundedShape
import com.kazemieh.www.shop.ui.theme.semiDarkText
import com.kazemieh.www.shop.ui.theme.spacing
import com.kazemieh.www.shop.ui.theme.unSelectedBottomBar
import com.kazemieh.www.shop.util.DigitHelper

@Composable
fun SellerInfoSection() {
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .height(MaterialTheme.spacing.small)
            .alpha(0.4f)
            .shadow(2.dp),
        color = Color.LightGray,
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                vertical = MaterialTheme.spacing.small,
                horizontal = MaterialTheme.spacing.medium,
            )

    ) {


        Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraSmall))

        Text(
            text = stringResource(id = R.string.seller),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.darkText,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = MaterialTheme.spacing.small)
        )

        Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))

        Row(
            modifier = Modifier.padding(
                top = MaterialTheme.spacing.small,
                start = MaterialTheme.spacing.small,
                end = MaterialTheme.spacing.small
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.digi_logo),
                modifier = Modifier
                    .size(25.dp)
                    .clip(MaterialTheme.roundedShape.small), contentDescription = ""
            )
            Spacer(modifier = Modifier.width(MaterialTheme.spacing.medium))

            Column {
                Text(
                    text = stringResource(id = R.string.digikala),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.darkText,
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "${DigitHelper.digitByLocate("101")}%" +
                                " رضایت خریداران | عملکرد ",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.semiDarkText,
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(top = MaterialTheme.spacing.small)
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(MaterialTheme.colorScheme.grayCategory)
                )
            }

        }


        Row(
            modifier = Modifier.padding(
                bottom = MaterialTheme.spacing.semiMedium,
                start = MaterialTheme.spacing.small,
                end = MaterialTheme.spacing.small
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.guarantee),
                modifier = Modifier
                    .padding(bottom = MaterialTheme.spacing.small)
                    .size(25.dp)
                    .clip(MaterialTheme.roundedShape.small), contentDescription = ""
            )

            Spacer(modifier = Modifier.width(MaterialTheme.spacing.medium))

            Column {
                Text(
                    modifier = Modifier
                        .padding(vertical = MaterialTheme.spacing.small),
                    text = stringResource(id = R.string.productWarranty),
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.darkText,
                )
                Spacer(
                    modifier = Modifier
                        .padding(top = MaterialTheme.spacing.small)
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(MaterialTheme.colorScheme.grayCategory)
                )
            }

        }



        Row(
            modifier = Modifier
                .padding(horizontal = MaterialTheme.spacing.biggerSmall)
        )
        {
            Column(
                modifier = Modifier
                    .width(16.dp)
                    .fillMaxHeight()
                    .padding(
                        vertical = MaterialTheme.spacing.small,
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.in_stock),
                    contentDescription = "",
                    modifier = Modifier
                        .size(16.dp),
                    tint = MaterialTheme.colorScheme.DarkCyan
                )

                Divider(
                    Modifier
                        .width(2.dp)
                        .height(16.dp)
                        .alpha(0.6f),
                    color = Color.LightGray
                )

                Icon(
                    painter = painterResource(id = R.drawable.circle),
                    contentDescription = "",
                    modifier = Modifier
                        .size(10.dp)
                        .padding(1.dp),
                    tint = MaterialTheme.colorScheme.DarkCyan,
                )

                Divider(
                    Modifier
                        .width(2.dp)
                        .height(16.dp)
                        .alpha(0.6f),
                    color = Color.LightGray
                )

                Icon(
                    painter = painterResource(id = R.drawable.circle),
                    contentDescription = "",
                    modifier = Modifier
                        .size(10.dp)
                        .padding(1.dp),
                    tint = MaterialTheme.colorScheme.DarkCyan,
                )


            }

            Column(Modifier.padding(horizontal = MaterialTheme.spacing.biggerMedium)) {

                Text(
                    text = stringResource(id = R.string.in_digi_stock),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.semiDarkText,
                    modifier = Modifier
                        .padding(vertical = MaterialTheme.spacing.extraSmall),
                )

                DetailRow(
                    painterResource(id = R.drawable.k1),
                    stringResource(id = R.string.digikala_send),
                    color = MaterialTheme.colorScheme.LightRed,
                    fontStyle = MaterialTheme.typography.bodySmall
                )

                DetailRow(
                    painterResource(id = R.drawable.k2),
                    stringResource(id = R.string.fast_send),
                    color = MaterialTheme.colorScheme.LightGreen,
                    fontStyle = MaterialTheme.typography.bodySmall
                )

            }
        }


        Spacer(
            modifier = Modifier
                .padding(top = MaterialTheme.spacing.small)
                .fillMaxWidth()
                .height(1.dp)
                .background(MaterialTheme.colorScheme.grayCategory)
        )




        Row(
            modifier = Modifier.padding(
                horizontal = MaterialTheme.spacing.small
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.digi_score),
                modifier = Modifier
                    .size(20.dp)
                    .clip(MaterialTheme.roundedShape.small), contentDescription = ""
            )

            Spacer(modifier = Modifier.width(MaterialTheme.spacing.medium))

            Column {
                Text(
                    modifier = Modifier
                        .padding(vertical = MaterialTheme.spacing.small),
                    text = stringResource(id = R.string.digiclub_get_score),
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.darkText,
                )

            }

        }


        Spacer(
            modifier = Modifier
                .padding(top = MaterialTheme.spacing.small)
                .fillMaxWidth()
                .height(1.dp)
                .background(MaterialTheme.colorScheme.grayCategory)
        )



        Row(
            modifier = Modifier.padding(
                bottom = MaterialTheme.spacing.small,
                start = MaterialTheme.spacing.small,
                end = MaterialTheme.spacing.small
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.info),
                modifier = Modifier
                    .size(20.dp)
                    .clip(MaterialTheme.roundedShape.small), contentDescription = ""
            )

            Spacer(modifier = Modifier.width(MaterialTheme.spacing.medium))

            Column {
                Text(
                    modifier = Modifier
                        .padding(vertical = MaterialTheme.spacing.small),
                    text = "${stringResource(id = R.string.manufacturer_price)} 111 ${
                        stringResource(
                            id = R.string.toman
                        )
                    }",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.unSelectedBottomBar,
                )
            }

        }


        Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraSmall))


        Row(
            modifier = Modifier
                .padding(
                    start = MaterialTheme.spacing.small,
                    end = MaterialTheme.spacing.small
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = stringResource(id = R.string.better_price_suggestion),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.unSelectedBottomBar,
            )

            Image(
                painter = painterResource(id = R.drawable.mark),
                modifier = Modifier
                    .size(25.dp), contentDescription = ""
            )
        }

    }


}