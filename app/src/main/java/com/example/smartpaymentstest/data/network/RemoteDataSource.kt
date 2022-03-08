package com.example.smartpaymentstest.data.network

import com.example.smartpaymentstest.data.network.model.*
import com.google.gson.JsonIOException
import com.google.gson.JsonParseException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

abstract class RemoteDataSource {

    abstract suspend fun getClimate(exclude  : String, latitude : String, longitude : String) : NetworkResult< NetworkResult<Daily> >

    protected suspend fun <T> safeApiCall(apiCall: suspend () -> T): NetworkResult<T> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiCall.invoke()
                return@withContext NetworkResult(result = response)
            } catch (throwable: Throwable) {
                return@withContext NetworkResult<T>(networkError = createError(throwable))
            }
        }
    }

    private fun createError(throwable: Throwable): NetworkError {
        return when (throwable) {
            is IOException -> {
                NetworkError(NetworkErrorType.CONNECTION_ERROR, throwable.message)
            }
            is HttpException -> {
                val bodyResponse: String? = throwable.response()?.errorBody()?.string()
                NetworkError(
                    NetworkErrorType.API_ERROR,
                    bodyResponse,
                    throwable.code().toString()
                )
            }
            is JsonParseException -> {
                NetworkError(NetworkErrorType.API_ERROR, throwable.message)
            }
            else -> {
                NetworkError(NetworkErrorType.UNKNOWN_ERROR, throwable.message)
            }
        }
    }

}