package com.soft.instagram.data.login.model

interface LoginRepository {

    /**
     *
     * 유저 토근 저장
     *
     * @param userToken 유저 token
     *
     */
    fun saveToken(userToken: Long)
}
