package com.soft.instagram.util.extensions

import android.content.SharedPreferences
import androidx.core.content.edit

/**
 * [SharedPreferences] 확장 함수
 */

operator fun SharedPreferences.get(name: String, default: String? = null) = getString(name, default)

operator fun SharedPreferences.set(name: String, value: String) = edit { putString(name, value) }

operator fun SharedPreferences.get(name: String, default: Long) = getLong(name, default)

operator fun SharedPreferences.set(name: String, value: Long) = edit { putLong(name, value) }
