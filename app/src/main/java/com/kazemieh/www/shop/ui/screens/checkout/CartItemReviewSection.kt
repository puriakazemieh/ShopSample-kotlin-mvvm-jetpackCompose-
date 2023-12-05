package com.kazemieh.www.shop.ui.screens.checkout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.data.model.basket.CartDetails
import com.kazemieh.www.shop.data.model.basket.CartItem
import com.kazemieh.www.shop.ui.theme.DarkCyan
import com.kazemieh.www.shop.ui.theme.LightRed
import com.kazemieh.www.shop.ui.theme.LocalElevation
import com.kazemieh.www.shop.ui.theme.cardBackground
import com.kazemieh.www.shop.ui.theme.roundedShape
import com.kazemieh.www.shop.ui.theme.spacing
import com.kazemieh.www.shop.util.DigitHelper.digitByLocate


@Composable
fun CartItemReviewSection(
    shippingCost: String,
    cartDetail: CartDetails,
    currentCartItems: List<CartItem>
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .padding(
                    MaterialTheme.spacing.medium,
                )
                .align(Alignment.Start),
            text = stringResource(id = R.string.deliveryAndTimeMethod),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding( MaterialTheme.spacing.small                ),
            shape = MaterialTheme.roundedShape.small,
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.cardBackground),
            elevation = CardDefaults.cardElevation(LocalElevation.current.veryExtraSmall)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = MaterialTheme.spacing.semiMedium
                    )
            ) {


                Text(
                    text = digitByLocate(stringResource(id = R.string.delivery_1)),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = MaterialTheme.spacing.medium)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .size(16.dp),
                        tint = MaterialTheme.colorScheme.LightRed,
                        painter = painterResource(id = R.drawable.k1),
                        contentDescription = ""
                    )

                    Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))

                    Text(
                        text = stringResource(id = R.string.fast_send),
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.LightRed,
                    )

                    Spacer(modifier = Modifier.width(MaterialTheme.spacing.medium))

                    Text(
                        text = digitByLocate("${cartDetail.totalCount} ${stringResource(id = R.string.goods)} "),
                        Modifier.padding(MaterialTheme.spacing.small),
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray,
                    )

                }


                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                  items(currentCartItems){
                      CheckoutProductCard(it)
                  }
                }

                Text(
                    text = stringResource(id = R.string.ready_to_send),
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.Gray,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(vertical = MaterialTheme.spacing.medium),
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = MaterialTheme.spacing.medium),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.choose_time),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.DarkCyan,
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.DarkCyan,
                        modifier = Modifier
                            .padding(horizontal = MaterialTheme.spacing.small)
                            .size(12.dp)
                            .align(Alignment.CenterVertically)
                            .clickable {

                            }
                    )
                }

            }
        }
    }

}