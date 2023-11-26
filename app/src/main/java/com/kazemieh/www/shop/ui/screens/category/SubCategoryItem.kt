package com.kazemieh.www.shop.ui.screens.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.data.model.category.Sub
import com.kazemieh.www.shop.ui.theme.darkText
import com.kazemieh.www.shop.ui.theme.grayCategory
import com.kazemieh.www.shop.ui.theme.roundedShape
import com.kazemieh.www.shop.ui.theme.spacing
import com.kazemieh.www.shop.util.DigitHelper.digitByLocate

@Composable
fun SubCategoryItem(item: Sub) {
    Card(
        modifier = Modifier
            .width(140.dp)
            .padding(
                vertical = MaterialTheme.spacing.small,
                horizontal = MaterialTheme.spacing.small
            ),
        shape = MaterialTheme.roundedShape.small
    ) {

        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.grayCategory)
                .fillMaxWidth()
                .padding(vertical = MaterialTheme.spacing.semiMedium),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = rememberAsyncImagePainter(model = item.image), contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
            )
            
            Spacer(modifier = Modifier.height(12 .dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = item.name,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.darkText,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.Gray,
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.bodyMedium,
                text = "+${digitByLocate(item.count)} ${stringResource(id = R.string.commodity)}"
            )

        }

    }
}