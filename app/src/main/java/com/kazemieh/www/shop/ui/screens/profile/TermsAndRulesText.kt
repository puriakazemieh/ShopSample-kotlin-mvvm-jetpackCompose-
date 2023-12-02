package com.kazemieh.www.shop.ui.screens.profile

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import com.kazemieh.www.shop.ui.theme.spacing


@Composable
fun TermsAndRulesText(
    fullText: String,
    textColor: Color,
    underlinedText: List<String>,
    underlinedTextFontWeight: FontWeight = FontWeight.Medium,
    underlinedTextDecoration: TextDecoration = TextDecoration.Underline,
    fontSize: TextUnit,
    textAlign: TextAlign
) {
    Text(
        text = buildAnnotatedString {
            append(fullText)
            underlinedText.forEach { text ->
                val startIndex = fullText.indexOf(text)
                val endIndex = startIndex + text.length
                addStyle(
                    style = SpanStyle(
                        fontSize = fontSize,
                        fontWeight = underlinedTextFontWeight,
                        textDecoration = underlinedTextDecoration
                    ),
                    start = startIndex,
                    end = endIndex
                )
                addStyle(
                    style = SpanStyle(
                        fontSize = fontSize,
                        color = textColor
                    ),
                    start = 0,
                    end = fullText.length
                )
            }
        },
        modifier = Modifier.padding(
            horizontal = MaterialTheme.spacing.small,
            vertical = MaterialTheme.spacing.medium
        ),
        textAlign = textAlign,
    )


}