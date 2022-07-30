package com.soft.instagram.data.error.mapper

import android.content.Context
import com.soft.instagram.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import com.soft.instagram.data.error.*

class ErrorMapper @Inject constructor(@ApplicationContext val context: Context) : ErrorMapperSource{

    override fun getErrorString(errorId: Int): String {
        return context.getString(errorId)
    }

    override val errorMap: Map<Int, String>
        get() = mapOf(
            Pair(NETWORK_ERROR, getErrorString(R.string.network_error)),
            Pair(PASS_WORD_ERROR, getErrorString(R.string.invalid_password)),
            Pair(USER_NAME_ERROR, getErrorString(R.string.invalid_username)),
            Pair(CHECK_YOUR_FIELDS, getErrorString(R.string.invalid_username_and_password)),
            Pair(SEARCH_ERROR, getErrorString(R.string.search_error))
        ).withDefault { getErrorString(R.string.network_error) }
}