package com.kazemieh.www.shop.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.ui.theme.splashBg

@Composable
fun BottomNavigationBar(
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {

    val items = listOf(
        BottomNavItem(
            name = "خانه",
            route = Screen.Home.route,
            selectedIcon = painterResource(id = R.drawable.home_fill),
            unSelectedIcon = painterResource(id = R.drawable.home_outline)
        ),
        BottomNavItem(
            name = "دسته بندی",
            route = Screen.Category.route,
            selectedIcon = painterResource(id = R.drawable.category_fill),
            unSelectedIcon = painterResource(id = R.drawable.category_outline)
        ),
        BottomNavItem(
            name = "سبد خرید",
            route = Screen.Basket.route,
            selectedIcon = painterResource(id = R.drawable.cart_fill),
            unSelectedIcon = painterResource(id = R.drawable.cart_outline)
        ),
        BottomNavItem(
            name = "پروفایل",
            route = Screen.Profile.route,
            selectedIcon = painterResource(id = R.drawable.user_fill),
            unSelectedIcon = painterResource(id = R.drawable.user_outline)
        )
    )

    val backStackEntry = navController.currentBackStackEntryAsState()
    val showBottomBar = backStackEntry.value?.destination?.route in items.map {
        it.route
    }

    if (showBottomBar) {
        NavigationBar(
            modifier = modifier,
        ) {
            items.forEach {
                val selected = it.route == backStackEntry.value?.destination?.route
                NavigationBarItem(
                    selected = selected,
                    onClick = { onItemClick(it) },
                    label = {
                        Text(
                            text = it.name,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(6.dp)
                        )
                    },
                    icon = {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            if (selected) {
                                Icon(
                                    painter = it.selectedIcon,
                                    contentDescription = "",
                                    modifier = Modifier.height(20.dp)
                                )
                            } else {
                                Icon(
                                    painter = it.unSelectedIcon, contentDescription = "",
                                    modifier = Modifier.height(20.dp)
                                )
                            }
                        }
                    }
                )
            }
        }
    }
}

