package com.kazemieh.www.shop.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.kazemieh.www.shop.ui.theme.cardBackground
import com.kazemieh.www.shop.util.Constants.ENGLISH_LANG
import com.kazemieh.www.shop.util.Constants.USER_LANGUAGE

@Composable
fun IconWithRotate(
    imageVector: ImageVector,
    colorTint: Color = Color.White
) {


    if (USER_LANGUAGE == ENGLISH_LANG) {
        Icon(
            imageVector = imageVector,
            contentDescription = "",
            tint = colorTint,
            modifier = Modifier
                .graphicsLayer(rotationZ = 180f)
                .size(20.dp, 20.dp)
        )
    } else {
        Icon(
            imageVector = imageVector,
            contentDescription = "",
            tint = colorTint,
            modifier = Modifier.size(20.dp, 20.dp)
        )
    }

}

@Composable
fun IconWithRotate(painter: Painter, colorTint: Color) {


    if (USER_LANGUAGE == ENGLISH_LANG) {
        Icon(
            painter = painter,
            contentDescription = "",
            tint = colorTint,
            modifier = Modifier
                .graphicsLayer(rotationZ = 180f)
                .size(40.dp, 40.dp)
        )
    } else {
        Icon(
            painter = painter,
            contentDescription = "",
            tint = colorTint,
            modifier = Modifier.size(40.dp, 40.dp)
        )
    }

}