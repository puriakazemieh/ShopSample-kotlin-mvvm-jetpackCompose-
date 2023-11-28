package com.kazemieh.www.shop.ui.screens.basket

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.data.model.basket.CartItem
import com.kazemieh.www.shop.data.model.basket.CartStatus
import com.kazemieh.www.shop.ui.theme.LightCyan
import com.kazemieh.www.shop.ui.theme.LightGreen
import com.kazemieh.www.shop.ui.theme.LightRed
import com.kazemieh.www.shop.ui.theme.LocalElevation
import com.kazemieh.www.shop.ui.theme.amber
import com.kazemieh.www.shop.ui.theme.cardBackground
import com.kazemieh.www.shop.ui.theme.createIndication
import com.kazemieh.www.shop.ui.theme.createMutableInteractionSource
import com.kazemieh.www.shop.ui.theme.darkText
import com.kazemieh.www.shop.ui.theme.roundedShape
import com.kazemieh.www.shop.ui.theme.semiDarkText
import com.kazemieh.www.shop.ui.theme.spacing
import com.kazemieh.www.shop.util.Constants
import com.kazemieh.www.shop.util.DigitHelper
import com.kazemieh.www.shop.util.DigitHelper.digitByLocateAndSeparator
import com.kazemieh.www.shop.viewmodel.BasketViewModel


@Composable
fun CartItemCard(
    item: CartItem,
    mode: CartStatus,
    viewModel: BasketViewModel = hiltViewModel()
) {

    var count by remember {
        mutableStateOf(item.count)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.small),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.cardBackground),
        elevation = CardDefaults.cardElevation(LocalElevation.current.veryExtraSmall)

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.medium)

        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = stringResource(id = R.string.your_shopping_list),
                        style = MaterialTheme.typography.titleLarge,
                    )
                    Text(
                        text = "${count}  ${stringResource(id = R.string.product)}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.semiDarkText
                    )
                }
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.semiDarkText
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = MaterialTheme.spacing.small),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = item.image, placeholder = painterResource(
                            id = R.drawable.fresh
                        )
                    ),
                    contentDescription = "",
                    modifier = Modifier
                        .width(130.dp)
                        .height(90.dp)
                        .weight(0.3f)
                )

                Column(
                    modifier = Modifier
                        .padding(start = MaterialTheme.spacing.small)
                        .weight(0.7f)
                ) {
                    Text(
                        text = item.name,
                        style = MaterialTheme.typography.titleLarge,
                    )

                    DetailRow(
                        icon = painterResource(id = R.drawable.warranty),
                        text = stringResource(id = R.string.warranty),
                        color = MaterialTheme.colorScheme.semiDarkText,
                        fontStyle = MaterialTheme.typography.titleLarge
                    )

                    DetailRow(
                        icon = painterResource(id = R.drawable.store),
                        text = stringResource(id = R.string.my_shop),
                        color = MaterialTheme.colorScheme.semiDarkText,
                        fontStyle = MaterialTheme.typography.titleLarge
                    )


                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .width(16.dp)
                                .fillMaxHeight()
                                .padding(vertical = MaterialTheme.spacing.extraSmall),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.in_stock),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(16.dp),
                                tint = MaterialTheme.colorScheme.LightCyan
                            )
                            DashedDivider(
                                modifier = Modifier
//                                    .fillMaxWidth()
                                    .width(1.dp)
                                    .height(16.dp)
                                    .alpha(0.5f),
                                color = MaterialTheme.colorScheme.semiDarkText
                            )
                            Box(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .size(10.dp)
                                    .background(color = MaterialTheme.colorScheme.LightCyan)
                            )
                            DashedDivider(
                                modifier = Modifier
                                    .width(1.dp)
                                    .height(16.dp)
                                    .alpha(0.5f),
                                color = MaterialTheme.colorScheme.semiDarkText
                            )
                            Box(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .size(10.dp)
                                    .background(color = MaterialTheme.colorScheme.LightCyan)
                            )
                        }

                        Column(
                            modifier = Modifier.padding(start = 8.dp),
                            verticalArrangement = Arrangement.Center,
//                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = stringResource(id = R.string.warranty),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.semiDarkText,
                            )

                            DetailRow(
                                icon = painterResource(id = R.drawable.k1),
                                text = item.seller,
                                color = MaterialTheme.colorScheme.LightRed,
                                colorText = MaterialTheme.colorScheme.semiDarkText,
                                fontStyle = MaterialTheme.typography.bodySmall,
                                padding = 8.dp,
                                size = 12.dp
                            )

                            DetailRow(
                                icon = painterResource(id = R.drawable.k2),
                                text = stringResource(id = R.string.digikala_send),
                                color = MaterialTheme.colorScheme.LightGreen,
                                colorText = MaterialTheme.colorScheme.semiDarkText,
                                fontStyle = MaterialTheme.typography.bodySmall,
                                size = 12.dp,
                                padding = 8.dp
                            )
                        }
                    }


                }
            }

            Row(
                modifier = Modifier
                    .padding(top = 16.dp)
            ) {

                Card(
                    modifier = Modifier
                        .width(80.dp),
                    shape = MaterialTheme.roundedShape.extraSmall,
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.cardBackground),
                    elevation = CardDefaults.cardElevation(LocalElevation.current.veryExtraSmall)
                ) {

                    if (mode == CartStatus.CURRENT_CART) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            Icon(
                                painter = painterResource(id = R.drawable.ic_increase_24),
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.LightRed,
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable(
                                        onClick = {
                                            count++
                                            viewModel.changeCountCartItem(item.itemId, count)
                                        },
                                        interactionSource = createMutableInteractionSource(),
                                        indication = createIndication(
                                            color = Color.Gray,
                                            bounded = true,
                                        )
                                    ),
                            )
                            Text(
                                text = digitByLocateAndSeparator(count.toString()),//count.toString(),
                                color = MaterialTheme.colorScheme.LightRed,
                                modifier = Modifier
                                    .width(30.dp)
                                    .wrapContentHeight()
                                    .wrapContentWidth()
                            )
                            Icon(
                                painter = painterResource(id = if (count == 1) R.drawable.digi_trash else R.drawable.ic_decrease_24),
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.LightRed,
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable(
                                        onClick = {
                                            if (item.count == 1) {
                                                count = 1
                                                viewModel.removeFromCart(item)
                                            } else {
                                                count--
                                                viewModel.changeCountCartItem(item.itemId, count)
                                            }

                                        },
                                        interactionSource = createMutableInteractionSource(),
                                        indication = createIndication(
                                            color = Color.Gray,
                                            bounded = true
                                        )
                                    ),

                                )
                        }
                    } else {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_shopping_cart_checkout),
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.LightRed,
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable(
                                        onClick = {

                                            viewModel.changeStatusCartItem(
                                                item.itemId,
                                                CartStatus.CURRENT_CART
                                            )

                                        },
                                        interactionSource = createMutableInteractionSource(),
                                        indication = createIndication(
                                            color = Color.Gray,
                                            bounded = true
                                        )
                                    ),
                            )
                        }


                    }
                }


                Row(
                    modifier = Modifier
                        .padding(start = 32.dp)
                ) {
                    Text(
                        text =
                        digitByLocateAndSeparator(
                            DigitHelper.applyDiscount(
                                item.price,
                                item.discountPercent
                            ).toString()
                        ),
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
                                if (mode == CartStatus.CURRENT_CART) {
                                    viewModel.changeStatusCartItem(
                                        item.itemId,
                                        CartStatus.NEXT_CART
                                    )
                                } else {
                                    viewModel.removeFromCart(item)
                                }
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
                        stringResource(id = if (mode == CartStatus.NEXT_CART) R.string.delete_from_list else R.string.save_to_next_list),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = if (mode == CartStatus.NEXT_CART) MaterialTheme.colorScheme.amber else MaterialTheme.colorScheme.LightCyan
                    )
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = "",
                        tint = if (mode == CartStatus.NEXT_CART) MaterialTheme.colorScheme.amber else MaterialTheme.colorScheme.LightCyan
                    )
                }
            }

        }

    }
}


@Composable
fun DetailRow(
    icon: Painter,
    text: String,
    color: Color,
    fontStyle: TextStyle,
    size: Dp = 16.dp,
    padding: Dp = 0.dp,
    colorText: Color = MaterialTheme.colorScheme.darkText
) {
    Row(
        modifier = Modifier.padding(top = MaterialTheme.spacing.small),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            painter = icon,
            contentDescription = "",
            modifier = Modifier
//                .padding(start = padding)
                .size(size),
            tint = color
        )
        Text(
            text = text,
            style = fontStyle,
            modifier = Modifier.padding(start = MaterialTheme.spacing.extraSmall),
            color = colorText,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun DashedDivider(
    modifier: Modifier = Modifier,
    dashWidth: Dp = 4.dp,
    dashHeight: Dp = 2.dp,
    gapWidth: Dp = 2.dp,
    color: Color = Color.Gray,
) {
    Canvas(modifier) {
        val pathEffect = PathEffect.dashPathEffect(
            intervals = floatArrayOf(dashWidth.toPx(), gapWidth.toPx()),
            phase = 0f
        )

        drawLine(
            color = color,
            start = Offset(0f, 0f),
            end = Offset(0f, size.height),
            pathEffect = pathEffect,
            strokeWidth = dashHeight.toPx()
        )
    }
}


@Composable
fun currencyLogoChangeByLanguage(): Painter {
    return if (Constants.USER_LANGUAGE == Constants.ENGLISH_LANG) {
        painterResource(id = R.drawable.dollar)
    } else {
        painterResource(id = R.drawable.toman)
    }
}