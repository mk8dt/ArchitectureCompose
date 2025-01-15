package com.mk.architecture.core.manager.session

import kotlinx.coroutines.flow.Flow

interface SessionManager {

    val userId: Flow<Long>

    suspend fun saveUserId(userId: Long)
}