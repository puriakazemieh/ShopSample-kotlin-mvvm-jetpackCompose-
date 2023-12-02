package com.kazemieh.www.shop.ui.screens.profile

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
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
    } else{
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
    Text(text = "profile")
}

