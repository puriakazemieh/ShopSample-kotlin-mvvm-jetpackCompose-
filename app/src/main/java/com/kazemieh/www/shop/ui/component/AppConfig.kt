package com.kazemieh.www.shop.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.ui.screens.profile.ProfileScreenState
import com.kazemieh.www.shop.util.Constants.USER_ID
import com.kazemieh.www.shop.util.Constants.USER_LANGUAGE
import com.kazemieh.www.shop.util.Constants.USER_PASSWORD
import com.kazemieh.www.shop.util.Constants.USER_PHONE
import com.kazemieh.www.shop.util.Constants.USER_TOKEN
import com.kazemieh.www.shop.viewmodel.DataStoreViewModel
import com.kazemieh.www.shop.viewmodel.ProfileViewModel

@Composable
fun AppConfig(
    datastore: DataStoreViewModel = hiltViewModel(),
    profileViewModel: ProfileViewModel = hiltViewModel()
) {
    getDataStoreVariables(datastore)

    profileViewModel.refreshToken(USER_PHONE, USER_PASSWORD)
    val loginResponse by profileViewModel.loginResponse.collectAsState()

    LaunchedEffect(key1 = true) {
        if (loginResponse is NetworkResult.Success) {
            loginResponse.data?.let {
                if (it.token.isNotEmpty()) {
                    profileViewModel.screenState = ProfileScreenState.PROFILE_STATE
                    datastore.saveUserToken(it.token)
                    datastore.saveUserId(it.id)
                    datastore.saveUserPhone(it.phone)
                    datastore.saveUserPassword(USER_PASSWORD)
                    getDataStoreVariables(datastore)
                }
            }

        }
    }


}

private fun getDataStoreVariables(datastore: DataStoreViewModel) {
    USER_LANGUAGE = datastore.getUserLanguage()
    datastore.saveUserLanguage(USER_LANGUAGE)

    USER_TOKEN = datastore.getUserToken().toString()
    USER_ID = datastore.getUserId().toString()
    USER_PHONE = datastore.getUserPhone().toString()
    USER_PASSWORD = datastore.getUserPassword().toString()
}