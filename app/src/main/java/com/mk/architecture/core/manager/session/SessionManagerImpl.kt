package com.mk.architecture.core.manager.session

import kotlinx.coroutines.flow.Flow

class SessionManagerImpl : SessionManager {

    override val userId: Flow<Long>
        get() = TODO("Not yet implemented")

    override suspend fun saveUserId(userId: Long) {
        TODO("Not yet implemented")
    }
}