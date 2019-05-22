package com.apppoweron.koindi.util

import android.content.Context
import android.net.ConnectivityManager


fun isInternetAvailable(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    val activeNetworkInfo = connectivityManager?.activeNetworkInfo
    return activeNetworkInfo?.isConnected ?: false
}