package com.namnp.koin

import androidx.lifecycle.ViewModel

class MainViewModel(
    private val mainRepository: MainRepository,
): ViewModel() {

    fun fetchData() {
//        mainRepository.fetchData()
        println("fetch data")
    }
}