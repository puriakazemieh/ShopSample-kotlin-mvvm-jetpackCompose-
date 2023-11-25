package com.kazemieh.www.shop.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.ui.theme.LightRed
import com.kazemieh.www.shop.ui.theme.cardBackground
import com.kazemieh.www.shop.ui.theme.darkText
import com.kazemieh.www.shop.ui.theme.roundedShape
import com.kazemieh.www.shop.ui.theme.spacing

@Composable
fun AmazingShowMore() {
    Card(
        modifier = Modifier
            .size(180.dp, 375.dp)
            .padding(
                end = MaterialTheme.spacing.medium,
                start = MaterialTheme.spacing.semiSmall,
                top = MaterialTheme.spacing.semiLarge
            ),
        shape = MaterialTheme.roundedShape.small,
//        colors = CardDefaults.cardColors(
//            co ntentColor = Color.Cyan
//        ),

        ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.show_more),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.LightRed,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(id = R.string.see_all),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.darkText
            )

        }

    }
}