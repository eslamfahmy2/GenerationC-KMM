package com.example.generationckmm.android.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.generationckmm.android.presentation.components.navigation.MainAppGraph
import com.example.generationckmm.android.presentation.components.theme.AppMainTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppMainTheme {
                MainAppGraph()
            }
        }
    }
}
