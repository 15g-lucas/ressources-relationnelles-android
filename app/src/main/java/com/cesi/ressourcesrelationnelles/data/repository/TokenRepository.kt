package com.cesi.ressourcesrelationnelles.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.cesi.ressourcesrelationnelles.data.datastore.PreferencesKeys.AUTH_TOKEN
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class TokenRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    companion object {
        private val TOKEN_KEY = stringPreferencesKey("auth_token")
    }
    val tokenFlow: Flow<String?> = dataStore.data.map { prefs ->
        prefs[AUTH_TOKEN]
    }

    suspend fun saveToken(token: String) {
        dataStore.edit { prefs ->
            prefs[AUTH_TOKEN] = token
        }
    }

    suspend fun getToken(): String? {
        return dataStore.data.map { prefs ->
            prefs[AUTH_TOKEN]
        }.first()
    }

    suspend fun clearToken() {
        dataStore.edit { prefs ->
            prefs.remove(AUTH_TOKEN)
        }
    }
}