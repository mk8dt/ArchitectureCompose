package com.mk.architecture.core.manager.error.di

import com.mk.architecture.core.manager.error.DefaultErrorManager
import com.mk.architecture.core.manager.error.ErrorManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ErrorModule {

    @Binds
    abstract fun bindErrorHandle(
        defaultErrorHandler: DefaultErrorManager
    ): ErrorManager
}