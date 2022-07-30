package com.soft.instagram.di

import com.soft.instagram.data.error.mapper.ErrorMapper
import com.soft.instagram.data.error.mapper.ErrorMapperSource
import com.soft.instagram.usecase.errors.ErrorManager
import com.soft.instagram.usecase.errors.ErrorUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ErrorModule {
    @Binds
    @Singleton
    abstract fun provideErrorFactoryImpl(errorManager: ErrorManager): ErrorUseCase

    @Binds
    @Singleton
    abstract fun provideErrorMapper(errorMapper: ErrorMapper) : ErrorMapperSource
}