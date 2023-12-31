package com.kazemieh.www.shop.ui.screens.profile

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.ui.theme.darkText
import com.kazemieh.www.shop.ui.theme.selectedBottomBar
import com.kazemieh.www.shop.ui.theme.spacing
import com.kazemieh.www.shop.util.Constants.USER_PHONE
import com.kazemieh.www.shop.util.Constants.USER_TOKEN
import com.kazemieh.www.shop.util.InputValidation.isValidPassword
import com.kazemieh.www.shop.viewmodel.DataStoreViewModel
import com.kazemieh.www.shop.viewmodel.ProfileViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest

@Composable
fun RegisterScreen(
    profileViewModel: ProfileViewModel = hiltViewModel(),
    dataStoreViewModel: DataStoreViewModel= hiltViewModel()
) {

    val context = LocalContext.current


//    val loginResponse by profileViewModel.loginResponse.collectAsState()

    LaunchedEffect(key1 = Dispatchers.Main) {
        profileViewModel.loginResponse.collectLatest {
            when (it) {
                is NetworkResult.Success -> {
                    it.data?.let {
                        if (it.token.isNotEmpty()){
                            profileViewModel.screenState = ProfileScreenState.PROFILE_STATE
                            dataStoreViewModel.saveUserToken(it.token)
                            dataStoreViewModel.saveUserId(it.id)
                            dataStoreViewModel.saveUserPhone(it.phone)
                            USER_PHONE= it.phone
                            USER_TOKEN= it.token
                            dataStoreViewModel.saveUserPassword(profileViewModel.inputPasswordState)
                        }
                    }

                    Toast.makeText(
                        context,
                        it.message,
                        Toast.LENGTH_LONG
                    ).show()

                    profileViewModel.loadingState = false
                }

                is NetworkResult.Error -> {
                    profileViewModel.loadingState = false
                    Log.e("3636", "loginResponse error : ${it.message}")
                }

                is NetworkResult.Loading -> {}
            }
        }
    }




    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.digi_settings
                    ), contentDescription = "",
                    modifier = Modifier
                        .padding(
                            MaterialTheme.spacing.small
                        )
                        .size(MaterialTheme.spacing.semiLarge),
                    tint = MaterialTheme.colorScheme.selectedBottomBar
                )
            }

            IconButton(onClick = {}) {
                Icon(
                    Icons.Filled.Close,
                    contentDescription = "Close",
                    modifier = Modifier
                        .padding(MaterialTheme.spacing.small),
                    tint = MaterialTheme.colorScheme.selectedBottomBar
                )
            }

        }
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraLarge))
        Text(
            text = stringResource(id = R.string.set_password_text),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.darkText,
            fontWeight = FontWeight.Bold
        )
        MyEditText(
            value = profileViewModel.inputPhoneState,
            placeholder = stringResource(id = R.string.phone_and_email),
            onValueChange = {},
        )


        MyEditText(
            value = profileViewModel.inputPasswordState,
            placeholder = stringResource(id = R.string.set_password),
            onValueChange = {
                profileViewModel.inputPasswordState = it
            }
        )


        Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

        if (profileViewModel.loadingState) {
            LoadingButton()
        } else {
            MyButton(text = stringResource(id = R.string.digikala_login)) {
                if (isValidPassword(profileViewModel.inputPasswordState)) {

                    profileViewModel.login()

                } else {
                    Toast.makeText(
                        context,
                        context.resources.getText(R.string.password_format_error),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }


    }


}