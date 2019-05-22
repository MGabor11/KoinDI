package com.apppoweron.koindi.module

import android.content.Context
import com.apppoweron.koindi.api.GitHubBasicApi
import com.apppoweron.koindi.BASE_URL
import com.apppoweron.koindi.api.interceptor.GenericErrorInterceptor
import com.apppoweron.koindi.api.interceptor.InternetConnectionInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {
    single { getRetrofit(get()) }
    single { getApiInterface(get()) }
    single { getOkHttpClient(get(), get()) }
    single { getHttpLoggingInterceptor() }
}


fun getApiInterface(retroFit: Retrofit): GitHubBasicApi {
    return retroFit.create(GitHubBasicApi::class.java)
}


fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build()
}


fun getOkHttpClient(context: Context, httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(InternetConnectionInterceptor(context))
        .addInterceptor(GenericErrorInterceptor(context))
        .build()
}


fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return httpLoggingInterceptor
}