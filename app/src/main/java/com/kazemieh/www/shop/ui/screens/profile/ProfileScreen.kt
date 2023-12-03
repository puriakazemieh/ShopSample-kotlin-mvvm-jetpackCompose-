package com.kazemieh.www.shop.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.ui.screens.home.CenterBannerItem
import com.kazemieh.www.shop.ui.theme.myBackground
import com.kazemieh.www.shop.ui.theme.spacing
import com.kazemieh.www.shop.util.Constants.USER_PHONE
import com.kazemieh.www.shop.util.DigitHelper.digitByLocate
import com.kazemieh.www.shop.viewmodel.DataStoreViewModel
import com.kazemieh.www.shop.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(
    navController: NavHostController,
    datastore: DataStoreViewModel = hiltViewModel(),
    profileViewModel: ProfileViewModel = hiltViewModel()
) {

    if (!datastore.getUserToken().isNullOrBlank()) {
        Profile()
    } else {
        when (profileViewModel.screenState) {
            ProfileScreenState.LOGIN_STATE -> {
                LoginScreen(navController = navController)
            }

            ProfileScreenState.PROFILE_STATE -> {
                Profile()
            }

            ProfileScreenState.REGISTER_STATE -> {
                RegisterScreen()
            }
        }
    }


}

@Composable
fun Profile() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 80.dp)
    ) {
        item { TopBarSection() }
        item { ProfileHeaderSection() }
        item { RateSection() }
        item { ClubSection() }
        item { MyOrdersSection() }
        item { CenterBannerItem(painter = painterResource(id = R.drawable.digiclub1)) }
        item { ProfileMenuSection() }
        item { CenterBannerItem(painter = painterResource(id = R.drawable.digiclub2)) }

    }
}


@Composable
fun TopBarSection() {
    Row(
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(
                    id = R.drawable.digi_settings
                ), contentDescription = "",
                modifier = Modifier
                    .padding(
                        MaterialTheme.spacing.small
                    )
                    .size(MaterialTheme.spacing.semiLarge),
                tint = MaterialTheme.colorScheme.myBackground
            )
        }
        IconButton(onClick = {}) {
            Icon(
                Icons.Filled.Close,
                contentDescription = "Close",
                modifier = Modifier
                    .padding(MaterialTheme.spacing.small),
                tint = MaterialTheme.colorScheme.myBackground
            )
        }
    }
}

@Composable
fun ProfileHeaderSection() {
    Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "user")
        Text(text = digitByLocate(USER_PHONE))
    }
    Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))
}

@Composable
fun RateSection() {
    Row {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.49f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.digi_score),
                contentDescription = "",
                Modifier.size(42.dp)
            )
            Column(modifier = Modifier.padding(MaterialTheme.spacing.semiMedium)) {
                Text(text = digitByLocate("975") + " " + stringResource(id = R.string.score))
                Text(text = stringResource(id = R.string.digikala_score))
            }
        }

        Divider(
            modifier = Modifier
                .padding(start = MaterialTheme.spacing.semiMedium)
                .width(1.dp)
                .height(60.dp)
                .alpha(0.2f),
            color = Color.LightGray
        )
        Column(
            modifier = Modifier.weight(0.49f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.digi_wallet),
                contentDescription = "",
                Modifier.size(32.dp)
            )
            Text(
                text = stringResource(id = R.string.digikala_wallet_active),
                modifier = Modifier.padding(top = MaterialTheme.spacing.small)
            )
        }
    }
}

@Composable
fun ClubSection() {
    Divider(
        modifier = Modifier
            .padding(vertical = MaterialTheme.spacing.medium)
            .height(4.dp)
            .alpha(0.4f)
            .shadow(2.dp),
        color = Color.LightGray
    )
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.digi_user),
                contentDescription = "",
                Modifier.size(60.dp)
            )
            Text(
                text = stringResource(id = R.string.auth),
                modifier = Modifier.padding(top = MaterialTheme.spacing.small)
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.digi_club),
                contentDescription = "",
                Modifier.size(60.dp)
            )
            Text(
                text = stringResource(id = R.string.club),
                modifier = Modifier.padding(top = MaterialTheme.spacing.small)
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.digi_contact_us),
                contentDescription = "",
                Modifier.size(60.dp)
            )
            Text(
                text = stringResource(id = R.string.contact_us),
                modifier = Modifier.padding(top = MaterialTheme.spacing.small)
            )
        }
    }

    Divider(
        modifier = Modifier
            .padding(vertical = MaterialTheme.spacing.medium)
            .height(4.dp)
            .alpha(0.4f)
            .shadow(2.dp),
        color = Color.LightGray
    )

}

@Composable
fun MyOrdersSection() {
    Text(
        modifier = Modifier.padding(start = MaterialTheme.spacing.medium),
        style = MaterialTheme.typography.bodySmall,
        fontWeight = FontWeight.Bold,
        text = stringResource(id = R.string.my_orders),
    )

    LazyRow {
        item {
            MyOrdersItem(
                painterResource(id = R.drawable.digi_unpaid),
                stringResource(id = R.string.unpaid)
            )
        }
        item {
            MyOrdersItem(
                painterResource(id = R.drawable.digi_processing),
                stringResource(id = R.string.processing)
            )
        }
        item {
            MyOrdersItem(
                painterResource(id = R.drawable.digi_delivered),
                stringResource(id = R.string.delivered)
            )
        }
        item {
            MyOrdersItem(
                painterResource(id = R.drawable.digi_cancel),
                stringResource(id = R.string.canceled)
            )
        }
        item {
            MyOrdersItem(
                painterResource(id = R.drawable.digi_returned),
                stringResource(id = R.string.returned)
            )
        }

    }


}

@Composable
fun MyOrdersItem(painter: Painter, text: String) {
    Row(
        modifier = Modifier.padding(vertical = MaterialTheme.spacing.biggerMedium),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painter,
                contentDescription = "",
                Modifier.size(60.dp)
            )
            Text(
                text = text,
                modifier = Modifier.padding(top = MaterialTheme.spacing.small)
            )
        }

        Divider(
            modifier = Modifier
                .width(1.dp)
                .height(90.dp)
                .alpha(0.4f),
            color = Color.LightGray,
        )
    }
}

@Composable
fun ProfileMenuSection() {
    MenuRowItem(
        painter = painterResource(id = R.drawable.digiclub2),
        text ="test",
        isHaveDivider = true
    )
}