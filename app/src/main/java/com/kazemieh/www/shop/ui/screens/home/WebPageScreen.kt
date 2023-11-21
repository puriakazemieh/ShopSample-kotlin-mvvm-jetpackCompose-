package com.kazemieh.www.shop.ui.screens.home

import android.annotation.SuppressLint
import android.util.Log
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebPageScreen(navController: NavController, url: String) {

    Log.d("TAG", "WebPageScreen: $url")
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webChromeClient = WebChromeClient()
            settings.javaScriptEnabled = true
            settings.userAgentString = System.getProperty("http.agent")
            loadUrl(url)
        }
    }, update = {
        it.loadUrl(url)
    })
}
