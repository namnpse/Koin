package com.namnp.koin

import org.koin.core.qualifier.named
import org.koin.dsl.module

val activityModule = module {
    scope<MainActivity> {
        // if provide 2 strings (2 dependencies that have the same type)
        // -> need to distinguish by `qualifier`)
        scoped(qualifier = named("android")) { "Android" }
        scoped(qualifier = named("ios")) { "iOS" }
    }
}