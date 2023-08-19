package com.himanshu.gmailapp.retrofit

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Information(
    @SerialName(value = "shop_message")
    val shopMessage: String
)