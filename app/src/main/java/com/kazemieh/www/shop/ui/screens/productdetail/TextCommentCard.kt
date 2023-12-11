package com.kazemieh.www.shop.ui.screens.productdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.data.model.productdetail.Comment
import com.kazemieh.www.shop.ui.theme.Green
import com.kazemieh.www.shop.ui.theme.LocalElevation
import com.kazemieh.www.shop.ui.theme.Oranges
import com.kazemieh.www.shop.ui.theme.cardBackground
import com.kazemieh.www.shop.ui.theme.darkText
import com.kazemieh.www.shop.ui.theme.grayAlpha
import com.kazemieh.www.shop.ui.theme.roundedShape
import com.kazemieh.www.shop.ui.theme.semiDarkText
import com.kazemieh.www.shop.ui.theme.spacing
import com.kazemieh.www.shop.util.DigitHelper.gregorianToJalali


@Composable
fun TextCommentCard(
    item: Comment
) {


    val dateParts = item.updatedAt.substringBefore("T").split("-")
    val year = dateParts[0].toInt()
    val month = dateParts[1].toInt()
    val day = dateParts[2].toInt()

    val context = LocalContext.current

    var iconSuggestion = R.drawable.like
    var colorSuggestion = MaterialTheme.colorScheme.Green
    var textSuggestion = context.getString(R.string.good_comment)
    var iconRotation = 0f
    when (item.star) {
        in Int.MIN_VALUE..2 -> {
            iconSuggestion = R.drawable.like
            colorSuggestion = MaterialTheme.colorScheme.Oranges
            textSuggestion = context.getString(R.string.bad_comment)
            iconRotation = 180f
        }
        in 2..3 -> {
            iconSuggestion = R.drawable.info
            colorSuggestion = MaterialTheme.colorScheme.semiDarkText
            textSuggestion = context.getString(R.string.so_so_comment)
            iconRotation = 0f
        }
        in 3..Int.MAX_VALUE -> {
            iconSuggestion = R.drawable.like
            colorSuggestion = MaterialTheme.colorScheme.Green
            textSuggestion = context.getString(R.string.good_comment)
            iconRotation = 0f
        }
    }




    Card(
        modifier = Modifier
            .padding(
                horizontal = MaterialTheme.spacing.small,
                vertical = MaterialTheme.spacing.medium,
            )
            .width(260.dp)
            .height(210.dp),
        elevation = CardDefaults.cardElevation(LocalElevation.current.veryExtraSmall),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.cardBackground),
        shape = MaterialTheme.roundedShape.small,
//        elevation = 2.dp,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(MaterialTheme.spacing.medium)
        ) {
            Text(
                text = item.title,
                color = MaterialTheme.colorScheme.darkText,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.headlineLarge,
            )

            Row(
                modifier = Modifier
                    .padding(vertical = MaterialTheme.spacing.small),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = iconSuggestion),
                    contentDescription = "",
                    Modifier
                        .size(16.dp)
                        .rotate(iconRotation),
                    tint = colorSuggestion
                )
                Text(
                    text = textSuggestion,
                    Modifier
                        .padding(start = MaterialTheme.spacing.extraSmall),
                    maxLines = 1,
                    style = MaterialTheme.typography.headlineLarge,
                    color = colorSuggestion
                )
            }


            Text(
                text = item.description,
                Modifier.weight(1f),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.headlineLarge,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = gregorianToJalali(year, month, day),
                    color = MaterialTheme.colorScheme.semiDarkText,
                    style = MaterialTheme.typography.headlineLarge,
                )
                Icon(
                    painter = painterResource(id = R.drawable.dot),
                    contentDescription = "",
                    Modifier
                        .size(20.dp)
                        .padding(horizontal = MaterialTheme.spacing.small),
                    tint = MaterialTheme.colorScheme.grayAlpha
                )
                Text(
                    text = item.userName,
                    color = MaterialTheme.colorScheme.grayAlpha,
                    style = MaterialTheme.typography.headlineLarge
                )
            }

        }
    }
}