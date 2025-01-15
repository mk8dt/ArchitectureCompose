package com.mk.architecture.core.manager.error

const val HTTP_STATUS_403 = 403
const val HTTP_STATUS_404 = 404
const val HTTP_STATUS_500 = 500
const val HTTP_STATUS_NEED_UPDATE = 416

sealed class ResultException : Throwable() {

    data object NoInternetConnect : ResultException(){
        private fun readResolve(): Any = NoInternetConnect
    }

    data object Forbidden : ResultException() {
        private fun readResolve(): Any = Forbidden
    }

    data object NotFound : ResultException() {
        private fun readResolve(): Any = NotFound
    }

    data object ServerError : ResultException() {
        private fun readResolve(): Any = ServerError
    }

    data object UpdateAppNeeded : ResultException() {
        private fun readResolve(): Any = UpdateAppNeeded
    }

    data object UnknownError : ResultException() {
        private fun readResolve(): Any = UnknownError
    }

    data object JSONError : ResultException() {
        private fun readResolve(): Any = JSONError
    }
}