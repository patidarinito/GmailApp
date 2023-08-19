package com.himanshu.gmailapp.retrofit

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Shop(
    @SerialName(value = "information")
    val information: Information,
    @SerialName(value = "products")
    val products: Products
)