package com.namnp.koin

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {

    single {
        Retrofit.Builder()
            .baseUrl("https://userapi.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }

    // singleton, single instance in the whole app lifecycle
    // if 2 view models need that dependency -> only 1 instance, reused for both
    single<MainRepository> {
        MainRepositoryImpl(get())
    }

    // create new instance when other components request/need dependency
    // if 2 view models need that dependency -> create 2 different instances
//    factory<MainRepository> {
//        MainRepositoryImpl(get())
//    }

    viewModel {
        MainViewModel(get())
    }

}