package com.kazemieh.www.shop.ui.screens.profile

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kazemieh.www.shop.ui.theme.CursorColor
import com.kazemieh.www.shop.ui.theme.DarkCyan
import com.kazemieh.www.shop.ui.theme.roundedShape
import com.kazemieh.www.shop.ui.theme.searchBarBg
import com.kazemieh.www.shop.ui.theme.spacing

@Composable
fun MyEditText(
    value: String,
    onValueChange: (it:String) -> Unit,
    placeholder:String,
) {
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        modifier = Modifier
            .fillMaxWidth()
//            .height(92.dp)
            .padding(
                start = MaterialTheme.spacing.semiSmall,
                end = MaterialTheme.spacing.semiSmall,
                top = MaterialTheme.spacing.semiSmall,
                bottom = MaterialTheme.spacing.semiSmall,
            ),
        shape = MaterialTheme.roundedShape.small,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.searchBarBg,
            focusedIndicatorColor = MaterialTheme.colorScheme.DarkCyan,
            unfocusedIndicatorColor =  MaterialTheme.colorScheme.searchBarBg,
            cursorColor =  MaterialTheme.colorScheme.CursorColor,
        ),
        placeholder = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ){
                Text(
                    text = placeholder,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium,
                )
            }
        }
    )
}