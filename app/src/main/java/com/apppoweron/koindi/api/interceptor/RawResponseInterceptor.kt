package com.apppoweron.koindi.api.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.adapter.rxjava2.Result.response


class RawResponseInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())

        val responseBodyCopy = response.peekBody(java.lang.Long.MAX_VALUE)
        val bodyCopy = responseBodyCopy.string()


        if (bodyCopy?.length == 1) {
            val isOk: String = if (bodyCopy == "1") {
                "true"
            } else {
                "false"
            }
            return response.newBuilder().body(
                ResponseBody.create(
                    response?.body()?.contentType(), "{\n" +
                            "\t\"isOK\":" + isOk + "\n" +
                            "}"
                )
            )
                .build()
        }
        //return response.newBuilder().body(ResponseBody.create(response?.body()?.contentType(), responseBody)).build()
        return response
    }

}