package com.namnp.koin

import retrofit2.http.GET

interface UserApi {

    @GET("/users")
    fun fetchData()
}