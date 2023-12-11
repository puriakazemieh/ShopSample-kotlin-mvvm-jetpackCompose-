package com.kazemieh.www.shop.ui.screens.productdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.data.model.productdetail.ProductDetail
import com.kazemieh.www.shop.ui.theme.DarkCyan
import com.kazemieh.www.shop.ui.theme.Gold
import com.kazemieh.www.shop.ui.theme.LightCyan
import com.kazemieh.www.shop.ui.theme.darkText
import com.kazemieh.www.shop.ui.theme.grayAlpha
import com.kazemieh.www.shop.ui.theme.grayCategory
import com.kazemieh.www.shop.ui.theme.semiDarkText
import com.kazemieh.www.shop.ui.theme.spacing
import com.kazemieh.www.shop.util.DigitHelper.digitByLocate


@Composable
fun ProductDetailHeaderSection(
    item: ProductDetail
) {


    Column {
        Text(
            text = "${stringResource(id = R.string.category)} / ${item.category}",
            color = MaterialTheme.colorScheme.DarkCyan,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(horizontal = MaterialTheme.spacing.medium)
        )

        Text(
            text = item.name.toString(),
            color = MaterialTheme.colorScheme.darkText,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(
                horizontal = MaterialTheme.spacing.medium,
                vertical = MaterialTheme.spacing.small
            ),
            maxLines = 2
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = MaterialTheme.spacing.medium)
                .fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.star),
                contentDescription = "",
                modifier = Modifier.size(15.dp),
                tint = MaterialTheme.colorScheme.Gold
            )
            Text(
                text = digitByLocate(item.star.toString()),
                color = MaterialTheme.colorScheme.semiDarkText,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(horizontal = 2.dp)
            )
            Text(
                text = digitByLocate("(${item.starCount})"),
                color = MaterialTheme.colorScheme.grayAlpha,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(end = MaterialTheme.spacing.small)
            )

            Icon(
                painter = painterResource(id = R.drawable.dot),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.grayAlpha,
                modifier = Modifier
                    .size(7.dp)
                    .padding(horizontal = 1.dp)
            )

            Text(
                text = digitByLocate("${item.commentCount} ${stringResource(R.string.user_comments)}"),
                color = MaterialTheme.colorScheme.DarkCyan,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.small),
            )

            Icon(
                painter = painterResource(id = R.drawable.dot),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.grayAlpha,
                modifier = Modifier
                    .size(7.dp)
                    .padding(horizontal = 1.dp)
            )
            Text(
                text = digitByLocate("${item.viewCount} ${stringResource(R.string.view)}"),
                color = MaterialTheme.colorScheme.DarkCyan,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.small),
            )
        }


        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(
                    horizontal = MaterialTheme.spacing.medium,
                    vertical = MaterialTheme.spacing.small,
                )
                .fillMaxWidth()
        ){
            Icon(
                painter = painterResource(id = R.drawable.like),
                contentDescription = "",
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.colorScheme.LightCyan
            )

            Text(
                text = digitByLocate("90% (80نفر) از خریداران این کالا را پیشنهاد کرده اند."),
                color = MaterialTheme.colorScheme.semiDarkText,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.small)
            )
        }

        Divider(
            color = MaterialTheme.colorScheme.grayCategory,
            thickness = 1.dp,
            modifier = Modifier.padding(horizontal = MaterialTheme.spacing.medium))


    }
}