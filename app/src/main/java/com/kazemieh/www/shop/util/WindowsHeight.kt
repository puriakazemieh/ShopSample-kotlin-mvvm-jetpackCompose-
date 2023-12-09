package com.kazemieh.www.shop.util

import android.annotation.SuppressLint
import android.content.Context
import android.view.ViewConfiguration


@SuppressLint("InternalInsetResource", "DiscouragedApi")
fun Context.statusBarHeight() : Int {
    var result = 0
    val resourceId = this.resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        result = this.resources.getDimensionPixelSize(resourceId)
    }
    return result
}

@SuppressLint("InternalInsetResource", "DiscouragedApi")
fun  Context.navigationBarHeight(): Int {
    val hasMenuKey: Boolean = ViewConfiguration.get(this).hasPermanentMenuKey()
    val resourceId: Int =
        this.resources.getIdentifier("navigation_bar_height", "dimen", "android")
    return if (resourceId > 0 && !hasMenuKey) {
        this.resources.getDimensionPixelSize(resourceId)
    } else {
        0
    }
}