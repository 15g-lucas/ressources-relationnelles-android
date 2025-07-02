package com.cesi.ressourcesrelationnelles.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.cesi.ressourcesrelationnelles.ui.screen.login.LoginScreen
import com.cesi.ressourcesrelationnelles.ui.screen.profile.ProfileScreen
import com.cesi.ressourcesrelationnelles.ui.screen.register.RegisterScreen
import com.cesi.ressourcesrelationnelles.ui.theme.RessourcesRelationnellesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RessourcesRelationnellesTheme {
                ProfileScreen()
            }
        }
    }
}
