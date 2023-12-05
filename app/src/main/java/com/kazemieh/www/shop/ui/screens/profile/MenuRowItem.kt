package com.kazemieh.www.shop.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.kazemieh.www.shop.ui.theme.searchBarBg
import com.kazemieh.www.shop.ui.theme.selectedBottomBar
import com.kazemieh.www.shop.ui.theme.spacing

@Composable
fun MenuRowItem(painter: Painter, isHaveDivider: Boolean, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = MaterialTheme.spacing.medium)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painter, contentDescription = null,
                modifier = Modifier
                    .size(36.dp)
                    .padding(MaterialTheme.spacing.small)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.9f)
                .padding(start = 8.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(text = text)
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "",
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colorScheme.selectedBottomBar
                )
            }
            if (isHaveDivider)
                Divider(
                    color = MaterialTheme.colorScheme.selectedBottomBar,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .alpha(0.4f)
                )
        }
    }
}