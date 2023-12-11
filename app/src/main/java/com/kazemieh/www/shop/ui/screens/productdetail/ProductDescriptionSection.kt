package com.kazemieh.www.shop.ui.screens.productdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.navigation.Screen
import com.kazemieh.www.shop.ui.theme.darkText
import com.kazemieh.www.shop.ui.theme.grayCategory
import com.kazemieh.www.shop.ui.theme.searchBarBg
import com.kazemieh.www.shop.ui.theme.spacing
import com.kazemieh.www.shop.ui.theme.unSelectedBottomBar


@Composable
fun ProductDescriptionSection(
    navController: NavController,
    description: String,
    technicalFeatures: String,
) {


    var isDescription by remember { mutableStateOf(true) }
    if (description.isBlank()) {
        isDescription = false
    }

    var isTechnicalFeatures by remember { mutableStateOf(true) }
    if (technicalFeatures == "null") {
        isTechnicalFeatures = false
    }


    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .height(MaterialTheme.spacing.small)
            .alpha(0.4f)
            .shadow(2.dp),
        color = Color.LightGray,
    )

    Text(
        modifier = Modifier
            .padding(
                horizontal = MaterialTheme.spacing.small,
                vertical = MaterialTheme.spacing.medium
            ),
        text = stringResource(id = R.string.product_desc),
        style = MaterialTheme.typography.headlineLarge,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colorScheme.darkText,
    )

    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(MaterialTheme.colorScheme.grayCategory)
    )

    if (isTechnicalFeatures) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate(
                        Screen.ProductTechnicalFeatures.withArgs(
                            technicalFeatures
                        )
                    )
                }
                .padding(
                    horizontal = MaterialTheme.spacing.medium,
                    vertical = MaterialTheme.spacing.medium
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.technical_specifications),
                color = MaterialTheme.colorScheme.darkText,
            )
            Icon(
                Icons.Outlined.KeyboardArrowLeft,
                contentDescription = "",
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colorScheme.searchBarBg
            )
        }
    }



    if (isDescription) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(MaterialTheme.colorScheme.grayCategory)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate(Screen.ProductDescription.withArgs(description))
                }
                .padding(MaterialTheme.spacing.medium),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.product_introduce),
                color = MaterialTheme.colorScheme.darkText,
            )
            Icon(
                Icons.Outlined.KeyboardArrowLeft,
                contentDescription = "",
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colorScheme.searchBarBg
            )
        }
    }




    Row(
        modifier = Modifier
            .padding(
                MaterialTheme.spacing.semiMedium,
            )
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            modifier = Modifier.padding(horizontal = MaterialTheme.spacing.small),
            text = stringResource(id = R.string.product_desc_feedback),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.unSelectedBottomBar,
        )

        Image(
            painter = painterResource(id = R.drawable.info),
            modifier = Modifier
                .size(20.dp), contentDescription = ""
        )
    }
}