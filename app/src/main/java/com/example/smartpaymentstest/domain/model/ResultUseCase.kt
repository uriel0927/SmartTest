package com.example.smartpaymentstest.domain.model

import com.example.smartpaymentstest.data.network.model.Daily
import com.example.smartpaymentstest.data.network.model.NetworkErrorType

sealed class ResultUseCase{

    data class Success(val weathers : Daily) : ResultUseCase()

    data class Failure(val errorType : NetworkErrorType) : ResultUseCase()

}
