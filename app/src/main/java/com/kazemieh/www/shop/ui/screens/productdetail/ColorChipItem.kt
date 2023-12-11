package com.kazemieh.www.shop.ui.screens.productdetail

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kazemieh.www.shop.data.model.productdetail.ProductColor
import com.kazemieh.www.shop.ui.theme.roundedShape
import com.kazemieh.www.shop.ui.theme.spacing


@Composable
fun ColorChipItem(
    item: ProductColor
) {

    Surface(
        modifier = Modifier.padding(MaterialTheme.spacing.extraSmall),
        shape = MaterialTheme.roundedShape.biggerMedium,
    ) {

        Row(
            modifier = Modifier.padding(MaterialTheme.spacing.small),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Canvas(
                modifier = Modifier
                    .size(20.dp)
                    .border(0.5.dp, Color.Gray, CircleShape),
                onDraw = {
                    drawCircle(Color(("ff" + item.code.removePrefix("#").lowercase()).toLong(16)))
                }
            )

            Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))

            Text(
                text = item.color,
                style = MaterialTheme.typography.headlineLarge
            )

        }

    }


}