package com.mk.architecture.core.manager.error

import android.accounts.NetworkErrorException
import com.mk.architecture.core.manager.error.ResultException.Forbidden
import com.mk.architecture.core.manager.error.ResultException.JSONError
import com.mk.architecture.core.manager.error.ResultException.NoInternetConnect
import com.mk.architecture.core.manager.error.ResultException.NotFound
import com.mk.architecture.core.manager.error.ResultException.ServerError
import com.mk.architecture.core.manager.error.ResultException.UnknownError
import com.mk.architecture.core.manager.error.ResultException.UpdateAppNeeded
import kotlinx.coroutines.CoroutineExceptionHandler
import org.json.JSONException
import retrofit2.HttpException
import javax.inject.Inject

interface ErrorManager {
    fun handle(error: Throwable): ResultException
}

class DefaultErrorManager @Inject constructor() : ErrorManager {

    override fun handle(error: Throwable): ResultException {
        return when (error) {
            is NetworkErrorException -> NoInternetConnect
            is HttpException -> mapNetworkError(error.code())
            is JSONException -> mapJsonError()
            else -> UnknownError
        }
    }

    private fun mapNetworkError(errorCode: Int): ResultException =
        when (errorCode) {
            HTTP_STATUS_403 -> Forbidden
            HTTP_STATUS_404 -> NotFound
            HTTP_STATUS_NEED_UPDATE -> UpdateAppNeeded
            HTTP_STATUS_500 -> ServerError
            else -> UnknownError
        }

    private fun mapJsonError(): ResultException {
        //TODO map JsonError
        return JSONError
    }
}