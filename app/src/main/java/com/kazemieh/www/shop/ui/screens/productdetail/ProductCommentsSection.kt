package com.kazemieh.www.shop.ui.screens.productdetail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.data.model.productdetail.Comment
import com.kazemieh.www.shop.navigation.Screen
import com.kazemieh.www.shop.ui.theme.LightCyan
import com.kazemieh.www.shop.ui.theme.darkText
import com.kazemieh.www.shop.ui.theme.spacing
import com.kazemieh.www.shop.util.DigitHelper
import com.kazemieh.www.shop.util.DigitHelper.digitByLocate
import com.kazemieh.www.shop.util.DigitHelper.digitByLocateAndSeparator


@Composable
fun ProductCommentsSection(
    navController: NavController,
    productId: String,
    comments: List<Comment>,
    commentCount: Int
) {


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
            .fillMaxWidth().clickable {
                navController.navigate(Screen.AllComment.withArgs(productId))
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.semiLarge),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.user_comments),
                color = MaterialTheme.colorScheme.darkText,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineLarge,
            )
            Text(
                text = "${digitByLocate(commentCount.toString())} " + stringResource(R.string.comment),
                color = MaterialTheme.colorScheme.LightCyan,
                style = MaterialTheme.typography.labelSmall,
            )
        }
    }


    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = MaterialTheme.spacing.medium),
    ){
        items(comments){ comment ->
            TextCommentCard(comment)
        }
    }

}