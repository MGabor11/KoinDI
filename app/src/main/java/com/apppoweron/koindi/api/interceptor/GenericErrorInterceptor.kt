package com.apppoweron.koindi.api.interceptor

import android.content.Context
import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.apppoweron.koindi.INTENT_USER_UNAUTHORIZED
import com.apppoweron.koindi.api.exception.BadRequestException
import com.apppoweron.koindi.api.exception.InternalServerErrorException
import com.apppoweron.koindi.api.exception.NoInternetException
import com.apppoweron.koindi.api.exception.UnauthorizedException
import okhttp3.Interceptor
import okhttp3.Response

class GenericErrorInterceptor(private val context: Context) : Interceptor {

    companion object {
        const val BAD_REQUEST = 400
        const val UNAUTHORIZED_ERROR = 401
        const val FORBIDDEN_ERROR = 403
        const val INTERNAL_SERVER_ERROR = 500
        const val NOT_FOUND = 404
    }


    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        when (response.code()) {
            BAD_REQUEST -> throw BadRequestException()
            UNAUTHORIZED_ERROR -> triggerUnauthorized()
            FORBIDDEN_ERROR -> triggerUnauthorized()
            INTERNAL_SERVER_ERROR -> throw InternalServerErrorException()
            NOT_FOUND -> throw NoInternetException()
        }
        //if (response.code() != 200) {
            //response.me
        //}
        //TODO handle GenericError

        return response
    }

    private fun triggerUnauthorized() {
        LocalBroadcastManager.getInstance(context).sendBroadcastSync(Intent(INTENT_USER_UNAUTHORIZED))
        throw UnauthorizedException()
    }


}