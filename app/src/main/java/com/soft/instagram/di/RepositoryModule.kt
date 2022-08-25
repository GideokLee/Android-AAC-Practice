package com.soft.instagram.di

import android.content.SharedPreferences
import com.soft.instagram.data.login.model.LoginRepository
import com.soft.instagram.data.login.model.LoginRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    fun provideLoginRepository(preference: SharedPreferences): LoginRepository =
        LoginRepositoryImpl(preference)
}
