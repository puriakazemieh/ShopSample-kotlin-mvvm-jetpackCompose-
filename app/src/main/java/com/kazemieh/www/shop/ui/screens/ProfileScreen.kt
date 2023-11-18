package com.kazemieh.www.shop.ui.screens

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.kazemieh.www.shop.MainActivity
import com.kazemieh.www.shop.util.Constants
import com.kazemieh.www.shop.util.Constants.ENGLISH_LANG
import com.kazemieh.www.shop.util.Constants.PERSIAN_LANG
import com.kazemieh.www.shop.util.Constants.USER_LANGUAGE
import com.kazemieh.www.shop.viewmodel.DataStoreViewModel

@Composable
fun ProfileScreen(
    navController: NavHostController,
    datastore: DataStoreViewModel = hiltViewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val activity = LocalContext.current as Activity

        Text(text = USER_LANGUAGE)

        Spacer(modifier = Modifier.size(20.dp))

        Button(onClick = {
            datastore.saveUserLanguage(PERSIAN_LANG)
            activity.apply {
                finish()
                startActivity(Intent(activity, MainActivity::class.java))
            }
        }) {
            Text(text = "fa")
        }

        Button(onClick = {
            datastore.saveUserLanguage(ENGLISH_LANG)
            activity.apply {
                finish()
                startActivity(Intent(activity, MainActivity::class.java))
            }
        }) {
            Text(text = "en")
        }
    }
}

