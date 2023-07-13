package com.namnp.koin

import org.koin.dsl.module

val activityModule = module {
    scope<MainActivity> {
        scoped { "Android" }
    }
}