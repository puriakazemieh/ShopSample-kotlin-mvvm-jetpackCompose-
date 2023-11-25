package com.kazemieh.www.shop.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.data.model.home.AmazingItem
import com.kazemieh.www.shop.ui.theme.DarkCyan
import com.kazemieh.www.shop.ui.theme.DarkRed
import com.kazemieh.www.shop.ui.theme.LightRed
import com.kazemieh.www.shop.ui.theme.cardBackground
import com.kazemieh.www.shop.ui.theme.roundedShape
import com.kazemieh.www.shop.ui.theme.semiDarkText
import com.kazemieh.www.shop.ui.theme.spacing
import com.kazemieh.www.shop.util.DigitHelper.applyDiscount
import com.kazemieh.www.shop.util.DigitHelper.digitByLocate
import com.kazemieh.www.shop.util.DigitHelper.digitByLocateAndSeparator

@Composable
fun AmazingOfferItem(amazingItem: AmazingItem) {
    Card(
        modifier = Modifier
            .fillMaxHeight()
            .width(170.dp)
            .padding(
                vertical = MaterialTheme.spacing.semiLarge,
                horizontal = MaterialTheme.spacing.semiSmall
            ),
        shape = MaterialTheme.roundedShape.small,
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.cardBackground),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = MaterialTheme.spacing.small)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = MaterialTheme.spacing.extraSmall)
            ) {

                Text(
                    text = stringResource(id = R.string.amazing_for_app),
                    modifier = Modifier.padding(start = MaterialTheme.spacing.small),
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.LightRed
                )

                Spacer(modifier = Modifier.height(10.dp))

                Image(
                    painter = rememberAsyncImagePainter(amazingItem.image),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp),
                    contentScale = ContentScale.FillBounds
                )


            }

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = MaterialTheme.spacing.small)
            ) {
                Text(
                    text = amazingItem.name,
                    modifier = Modifier
                        .fillMaxSize()
                        .height(48.dp)
                        .padding(
                            horizontal = MaterialTheme.spacing.small
                        ),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.in_stock),
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.DarkCyan,
                        modifier = Modifier
                            .size(22.dp)
                            .padding(2.dp)
                    )

                    Text(
                        text = amazingItem.seller,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.semiDarkText
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = MaterialTheme.spacing.small),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {

                    Box(
                        modifier = Modifier
                            .width(40.dp)
                            .height(24.dp)
                            .background(
                                color = MaterialTheme.colorScheme.DarkRed,
                                shape = CircleShape
                            )
                            .wrapContentWidth(Alignment.CenterHorizontally)
                            .wrapContentHeight(Alignment.CenterVertically)

                    ) {
                        Text(
                            text = "${digitByLocate(amazingItem.discountPercent.toString())}%",
//                            color = Color.White,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Column {
                        Row {
                            Text(
                                text =
                                digitByLocateAndSeparator(
                                    applyDiscount(
                                        amazingItem.price,
                                        amazingItem.discountPercent
                                    ).toString()
                                ),
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.SemiBold
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.toman),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(MaterialTheme.spacing.semiLarge)
                                    .padding(horizontal = MaterialTheme.spacing.extraSmall)
                            )

                        }
                        Text(
                            text = digitByLocateAndSeparator(amazingItem.price.toString()),
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.LightGray,
                            textDecoration = TextDecoration.LineThrough
                        )

                    }
                }

            }
        }
    }
}