package com.example.smartpaymentstest.data.network.model

import com.google.gson.annotations.SerializedName

data class ApiListResponse<T>(
    @SerializedName("list") val list: List<T>
)
