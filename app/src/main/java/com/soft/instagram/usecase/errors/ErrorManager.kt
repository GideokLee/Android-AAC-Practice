package com.soft.instagram.usecase.errors

import com.soft.instagram.data.error.Error
import com.soft.instagram.data.error.mapper.ErrorMapper
import javax.inject.Inject

class ErrorManager @Inject constructor(private val errorMapper: ErrorMapper) : ErrorUseCase{
    override fun getError(errorCode: Int): Error {
        return Error(code = errorCode, description = errorMapper.errorMap.getValue(errorCode))
    }
}