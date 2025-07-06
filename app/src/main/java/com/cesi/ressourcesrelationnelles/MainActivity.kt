package com.cesi.ressourcesrelationnelles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.rememberNavController
import com.cesi.ressourcesrelationnelles.navigation.AppNavHost
import com.cesi.ressourcesrelationnelles.navigation.NavRoutes
import com.cesi.ressourcesrelationnelles.MainViewModel
import com.cesi.ressourcesrelationnelles.di.LocalMainViewModel
import com.cesi.ressourcesrelationnelles.ui.theme.RessourcesRelationnellesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val mainViewModel: MainViewModel by viewModels()


        setContent {
            RessourcesRelationnellesTheme {
                val navController = rememberNavController()
                CompositionLocalProvider(
                    LocalMainViewModel provides mainViewModel
                ) {
                    AppNavHost(
                        navController = navController,
                        startDestination = "login"
                    )
                }
            }
        }
    }
}