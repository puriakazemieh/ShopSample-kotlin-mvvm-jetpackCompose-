package com.kazemieh.www.shop.ui.screens.productdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.kazemieh.www.shop.data.model.productdetail.ProductColor
import com.kazemieh.www.shop.ui.theme.darkText
import com.kazemieh.www.shop.ui.theme.spacing


@Composable
fun ProductSelectColorSection(
    colors: List<ProductColor>
) {

    Column(modifier = Modifier.padding(MaterialTheme.spacing.small)) {

        Text(
            text = "رنگ : انتخاب نشده",
            color = MaterialTheme.colorScheme.darkText,
            modifier = Modifier.padding(MaterialTheme.spacing.small),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )


        LazyRow() {
            items(colors) { productColor ->
                ColorChipItem(productColor)
            }
        }
    }

}