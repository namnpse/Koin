package com.namnp.koin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.namnp.koin.ui.theme.KoinTheme
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    // with non-compose
//    private val viewModel by viewModel<MainViewModel>()

    // inject a dependency that you want
//    private val api = get<UserApi>()

    // lazy inject, don't want to inject immediately, inject when needed (access the first time)
//    private val api by inject<UserApi>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoinTheme {
                // with compose
                val viewModel = getViewModel<MainViewModel>()
                viewModel.fetchData()
            }
        }
    }
}