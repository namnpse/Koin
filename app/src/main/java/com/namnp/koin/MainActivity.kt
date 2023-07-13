package com.namnp.koin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.namnp.koin.ui.theme.KoinTheme
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.activityRetainedScope
import org.koin.androidx.scope.activityScope
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.scope.Scope

class MainActivity : ComponentActivity(), AndroidScopeComponent {

    // inject scope dependency
    override val scope: Scope by activityScope()
//    override val scope: Scope by activityRetainedScope() // survive config changes
    private val android by inject<String>()
    // activityRetainedScope: keep dependency even when config changes
    // activityScope: config changes -> re-create new activity -> re-create the dependency

    // with non-compose
//    private val viewModel by viewModel<MainViewModel>()

    // inject a dependency that you want
//    private val api = get<UserApi>()

    // lazy inject, don't want to inject immediately, inject when needed (access the first time)
//    private val api by inject<UserApi>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Hello: $android")
        setContent {
            KoinTheme {
                // with compose
                val viewModel = getViewModel<MainViewModel>()
                viewModel.fetchData()
            }
        }
    }

}