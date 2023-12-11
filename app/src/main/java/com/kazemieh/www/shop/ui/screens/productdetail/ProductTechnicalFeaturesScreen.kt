package com.kazemieh.www.shop.ui.screens.productdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.ui.theme.darkText
import com.kazemieh.www.shop.ui.theme.grayCategory
import com.kazemieh.www.shop.ui.theme.searchBarBg
import com.kazemieh.www.shop.ui.theme.semiDarkText
import com.kazemieh.www.shop.ui.theme.spacing
import org.json.JSONObject


@Composable
fun ProductTechnicalFeaturesScreen(
    navController: NavHostController,
    jsonString: String
) {

    Column() {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = MaterialTheme.spacing.medium),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowForward,
                contentDescription = "",
                modifier = Modifier
                    .padding(horizontal = MaterialTheme.spacing.medium)
                    .clickable {
                        navController.popBackStack()
                    }
                    .size(24.dp)

            )

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(id = R.string.technical_specifications),
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.darkText,
            )

        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(MaterialTheme.colorScheme.searchBarBg)
        )



        Column(
            modifier = Modifier
                .padding(top = MaterialTheme.spacing.small)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(MaterialTheme.spacing.semiMedium),
                text = stringResource(id = R.string.specifications),
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.darkText,
            )


            val jsonObject = JSONObject(jsonString)
            val keys = jsonObject.keys()
            while (keys.hasNext()) {
                val key = keys.next()
                val value = jsonObject.get(key).toString()

                TechnicalFeaturesRow(key, value)
            }
        }

    }


}

@Composable
private fun TechnicalFeaturesRow(key: String, value: String) {


    Row {
        Column(
            modifier = Modifier
                .weight(0.35f)
                .padding(
                    vertical = MaterialTheme.spacing.small,
                    horizontal = MaterialTheme.spacing.medium
                )
        ) {
            Text(
                text = key,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.semiDarkText,
            )
        }

        Column(
            modifier = Modifier
                .weight(0.65f)
                .padding(
                    vertical = MaterialTheme.spacing.small,
                    horizontal = MaterialTheme.spacing.medium
                )
        ) {
            Text(
                text = value,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.darkText
            )
            Spacer(
                modifier = Modifier
                    .padding(top = MaterialTheme.spacing.biggerSmall)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(MaterialTheme.colorScheme.grayCategory)
            )
        }
    }

}