package com.cesi.ressourcesrelationnelles.di

import androidx.compose.runtime.staticCompositionLocalOf
import com.cesi.ressourcesrelationnelles.MainViewModel

val LocalMainViewModel = staticCompositionLocalOf<MainViewModel> {
    error("MainViewModel not provided")
}