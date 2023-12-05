package com.kazemieh.www.shop.ui.screens.basket

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
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
import androidx.navigation.NavController
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.navigation.Screen
import com.kazemieh.www.shop.ui.theme.LocalElevation
import com.kazemieh.www.shop.ui.theme.amber
import com.kazemieh.www.shop.ui.theme.cardBackground
import com.kazemieh.www.shop.ui.theme.darkText
import com.kazemieh.www.shop.ui.theme.roundedShape
import com.kazemieh.www.shop.ui.theme.spacing

@Composable
fun LoginOrRegisterSection(navController: NavController) {

    Card(
        modifier = Modifier
            .padding(MaterialTheme.spacing.medium)
            .clickable { navController.navigate(Screen.Profile.route) },
        shape = MaterialTheme.roundedShape.small,
        elevation = CardDefaults.cardElevation(LocalElevation.current.veryExtraSmall),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.cardBackground),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.medium),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Icon(
                painter = painterResource(id = R.drawable.pindo), contentDescription = null,
                tint = MaterialTheme.colorScheme.amber,
                modifier = Modifier
                    .size(30.dp)
                    .weight(0.1f)
                    .align(Alignment.Top)
            )
            Spacer(modifier = Modifier.weight(0.05f))
            Column(
                modifier = Modifier.weight(0.8f),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = stringResource(R.string.login_or_register),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.darkText,
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = stringResource(R.string.login_or_register_msg),
                    textAlign = TextAlign.Start,
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.bodySmall,
                )
            }

            Spacer(modifier = Modifier.weight(0.05f))

            Icon(
                painter = painterResource(id = R.drawable.arrow_back),
                contentDescription = "",
                tint = Color.Gray,
                modifier = Modifier
                    .size(22.dp)
                    .weight(0.1f)
                    .align(Alignment.Top)
                    .padding(top = MaterialTheme.spacing.small)

            )
        }

    }


}

