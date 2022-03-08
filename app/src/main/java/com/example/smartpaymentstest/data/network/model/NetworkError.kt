package com.example.smartpaymentstest.data.network.model

data class NetworkError(
    var type: NetworkErrorType,
    var rawError: String? = null,
    var errorCode: String? = null
) {
    val ensureErrorMessage: String
        get() {
            rawError?.let {
                return it
            }

            return type.name
        }
}