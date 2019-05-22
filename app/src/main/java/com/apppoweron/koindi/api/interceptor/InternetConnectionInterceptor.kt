package com.apppoweron.koindi.api.interceptor

import android.content.Context
import com.apppoweron.koindi.api.exception.NoInternetException
import com.apppoweron.koindi.util.isInternetAvailable
import okhttp3.Interceptor
import okhttp3.Response

class InternetConnectionInterceptor(val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if(!isInternetAvailable(context)){
            throw NoInternetException()
        }
        return chain.proceed(chain.request())
    }
}