package com.namnp.koin

class MainRepositoryImpl(
    private val userApi: UserApi
): MainRepository {

    override fun fetchData() {
        userApi.fetchData()
    }
}