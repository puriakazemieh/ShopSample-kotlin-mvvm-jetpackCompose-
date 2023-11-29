package com.kazemieh.www.shop.ui.screens.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.data.model.basket.CartDetails
import com.kazemieh.www.shop.data.model.basket.CartItem
import com.kazemieh.www.shop.ui.theme.LightRed
import com.kazemieh.www.shop.ui.theme.roundedShape
import com.kazemieh.www.shop.ui.theme.semiDarkText
import com.kazemieh.www.shop.ui.theme.spacing
import com.kazemieh.www.shop.util.DigitHelper
import com.kazemieh.www.shop.util.DigitHelper.digitByLocateAndSeparator


@Composable
fun CartPriceDetailSection(cartDetails: CartDetails) {


    Column(
        modifier = Modifier.padding(MaterialTheme.spacing.medium)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = stringResource(id = R.string.basket_summary),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(start = MaterialTheme.spacing.small)
            )
            Text(
                text = "${cartDetails.totalCount}   ${stringResource(id = R.string.product)}",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = MaterialTheme.spacing.small),
                color = MaterialTheme.colorScheme.semiDarkText
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        RowPrice(
            title = stringResource(id = R.string.goods_price),
            price = digitByLocateAndSeparator(cartDetails.totalPrice.toString())
        )
        RowPrice(
            title = stringResource(id = R.string.goods_discount),
            price = digitByLocateAndSeparator(cartDetails.totalDiscount.toString()),
            discountPercent = cartDetails.totalDiscount
        )

        RowPrice(
            title = stringResource(id = R.string.goods_total_price),
            price = digitByLocateAndSeparator(cartDetails.payablePrice.toString())
        )


        Text(
            text = stringResource(id = R.string.shipping_cost_alert),
            modifier = Modifier.padding(
                start = MaterialTheme.spacing.biggerMedium,
                top = MaterialTheme.spacing.medium
            )
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = MaterialTheme.spacing.medium)
                .height(1.dp)
                .alpha(0.4f),
            color = Color.LightGray
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.digi_score),
                    contentDescription = "",
                    Modifier.size(22.dp)
                )
                Text(
                    text = stringResource(id = R.string.digiclub_score),
                    modifier = Modifier.padding(start = MaterialTheme.spacing.small)
                )
            }
            Text(text = stringResource(id = R.string.score))
        }

        Text(
            text = stringResource(id = R.string.digiclub_description),
            modifier = Modifier.padding(
                start = MaterialTheme.spacing.biggerMedium,
                top = MaterialTheme.spacing.medium
            )
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = MaterialTheme.spacing.semiMedium)
                .height(1.dp)
                .alpha(0.4f),
            color = Color.LightGray
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Button(
                onClick = { },
                modifier = Modifier
//                    .clip(MaterialTheme.roundedShape.extraSmall)
                    .background(
                        MaterialTheme.colorScheme.LightRed,
                        MaterialTheme.roundedShape.small
                    )
                    .padding(horizontal = MaterialTheme.spacing.medium),
//                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.LightRed)
            ) {
                Text(text = stringResource(id = R.string.basket_summary))

            }
            Column {
                Text(
                    text = stringResource(id = R.string.goods_total_price),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.semiDarkText,
                    modifier = Modifier.padding(start = MaterialTheme.spacing.small)
                )
                Row {
                    Text(
                        text = digitByLocateAndSeparator(cartDetails.payablePrice.toString()),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    Icon(
                        painter = currencyLogoChangeByLanguage(),
                        contentDescription = "",
                        modifier = Modifier
                            .size(MaterialTheme.spacing.semiLarge)
                            .padding(horizontal = MaterialTheme.spacing.extraSmall)
                    )

                }
            }
        }


    }


}

@Composable
fun RowPrice(title: String, price: String, discountPercent: Long = 0) {

    val color =
        if (discountPercent != 0L) MaterialTheme.colorScheme.LightRed else LocalContentColor.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = MaterialTheme.spacing.semiExtraSmall),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = title,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.semiDarkText,
            modifier = Modifier.padding(start = MaterialTheme.spacing.small)
        )

        Row {
            Text(
                text = price,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = color
            )
            Icon(
                painter = currencyLogoChangeByLanguage(),
                contentDescription = "",
                modifier = Modifier
                    .size(MaterialTheme.spacing.semiLarge)
                    .padding(horizontal = MaterialTheme.spacing.extraSmall),
                tint = color
            )

        }
    }
}