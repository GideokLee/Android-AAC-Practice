package com.soft.instagram.data.login.model

import android.content.SharedPreferences
import com.soft.instagram.util.extensions.set
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val preferences: SharedPreferences
) : LoginRepository {

    override fun saveToken(userToken: Long) {
        preferences[USER_TOKEN] = userToken
    }

    companion object {
        private const val USER_TOKEN = "user-token"
    }
}
