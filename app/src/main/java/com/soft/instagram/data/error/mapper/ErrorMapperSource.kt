package com.soft.instagram.data.error.mapper

interface ErrorMapperSource {
    fun getErrorString(errorId: Int) :String
    val errorMap: Map<Int,String>
}