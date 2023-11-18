package com.kazemieh.www.shop.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.kazemieh.www.shop.util.Constants.USER_LANGUAGE
import com.kazemieh.www.shop.viewmodel.DataStoreViewModel

@Composable
fun AppConfig(
    datastore: DataStoreViewModel = hiltViewModel()
) {
    getDataStoreVariables(datastore)

}

private fun getDataStoreVariables(datastore: DataStoreViewModel) {
    USER_LANGUAGE = datastore.getUserLanguage()

}