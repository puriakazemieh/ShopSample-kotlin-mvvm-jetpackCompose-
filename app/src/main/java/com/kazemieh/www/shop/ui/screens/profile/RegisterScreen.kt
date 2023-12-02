package com.kazemieh.www.shop.ui.screens.profile

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.ui.theme.darkText
import com.kazemieh.www.shop.ui.theme.selectedBottomBar
import com.kazemieh.www.shop.ui.theme.spacing
import com.kazemieh.www.shop.util.InputValidation.isValidPassword
import com.kazemieh.www.shop.viewmodel.ProfileViewModel

@Composable
fun RegisterScreen(
    profileViewModel: ProfileViewModel = hiltViewModel()
) {

    val context = LocalContext.current
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


        MyButton(text = stringResource(id = R.string.digikala_login)) {
            if (isValidPassword(profileViewModel.inputPasswordState)) {

//                profileViewModel.login()

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