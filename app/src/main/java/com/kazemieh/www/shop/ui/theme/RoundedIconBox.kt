package com.kazemieh.www.shop.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun RoundedIconBox(
    title: String,
    image: Painter,
    bgColor: Color = Color.Transparent,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .width(LocalSpacing.current.s80)
            .clip(LocalShape.current.small)
            .clickable(
                onClick = {
                    onClick()
                },
                interactionSource = createMutableInteractionSource(),
                indication = createIndication(
                    color = Color.Gray,
                    bounded = true,
                )
            )
            .padding(LocalSpacing.current.small),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(LocalShape.current.biggerMedium)
                .background(bgColor)
        ) {
            Image(
                painter = image,
                contentDescription = "",
                modifier = Modifier.size(LocalSpacing.current.s52)
            )
        }
        Spacer(modifier = Modifier.height(LocalSpacing.current.small))

        Text(
            text = title,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.darkText,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

    }
}


@Composable
fun createMutableInteractionSource(): MutableInteractionSource = remember {
    MutableInteractionSource()
}

@Composable
fun createIndication(color: Color = Color.Red, bounded: Boolean = true) =
    rememberRipple(color = color, bounded = bounded)