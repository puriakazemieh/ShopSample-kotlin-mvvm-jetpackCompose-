package com.kazemieh.www.shop.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.ui.theme.LocalElevation
import com.kazemieh.www.shop.ui.theme.LocalShape
import com.kazemieh.www.shop.ui.theme.LocalSpacing
import com.kazemieh.www.shop.ui.theme.cardBackground
import com.kazemieh.www.shop.ui.theme.searchBarBg
import com.kazemieh.www.shop.ui.theme.unSelectedBottomBar
import com.kazemieh.www.shop.util.Constants
import com.kazemieh.www.shop.util.Constants.ENGLISH_LANG
import com.kazemieh.www.shop.util.Constants.USER_LANGUAGE

@Composable
fun SearchBarSection() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(LocalSpacing.current.s64)
//            .background(color = MaterialTheme.colorScheme.cardBackground)
            .padding(
                horizontal = LocalSpacing.current.medium,
                vertical = LocalSpacing.current.small
            ),
        elevation = CardDefaults.cardElevation(LocalElevation.current.zero)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(LocalShape.current.biggerSmall)
                .background(MaterialTheme.colorScheme.searchBarBg)
        ) {
            SearchContent()
        }

    }
}


@Composable
private fun SearchContent() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = LocalSpacing.current.s20),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            modifier = Modifier
                .height(LocalSpacing.current.semiLarge),
            painter = painterResource(id = R.drawable.round_search_24),
            contentDescription = ""
        )
        Text(
            modifier = Modifier
                .padding(start = LocalSpacing.current.s20),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.unSelectedBottomBar,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Normal,
            text = stringResource(id = R.string.search_in)
        )
        Image(
            modifier = Modifier
                .width(LocalSpacing.current.s80)
                .padding(LocalSpacing.current.extraSmall),
            painter = logoChangeByLanguage(),
            contentDescription = ""
        )
    }
}


@Composable
private fun logoChangeByLanguage(): Painter {
    return if (USER_LANGUAGE == ENGLISH_LANG) painterResource(id = R.drawable.digi_red_english)
    else painterResource(id = R.drawable.digi_red_persian)
}