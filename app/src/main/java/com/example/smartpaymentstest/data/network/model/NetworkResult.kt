package com.example.smartpaymentstest.data.network.model

class NetworkResult(val result: Daily? = null, val networkError: NetworkError? = null) {
    val isError: Boolean
        get() = networkError != null

    val requiredResult: Daily
        get() = result!!

    val requiredError: NetworkError
        get() = networkError!!
}