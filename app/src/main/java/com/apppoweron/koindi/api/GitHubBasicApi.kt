package com.apppoweron.koindi.api

import com.apppoweron.koindi.vo.Contributor
import com.apppoweron.koindi.vo.Repository
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubBasicApi {

    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Single<List<Repository>>

    @GET("repos/{user}/{repo}/contributors")
    fun listRepoContributors(
        @Path("user") user: String,
        @Path("repo") repo: String
    ): Observable<List<Contributor>>
}