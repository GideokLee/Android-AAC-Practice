package com.soft.instagram.usecase.errors

import com.soft.instagram.data.error.Error

interface ErrorUseCase {
    fun getError(errorCode: Int): Error
}