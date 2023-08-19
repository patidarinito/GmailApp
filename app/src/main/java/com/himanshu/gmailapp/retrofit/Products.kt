package com.himanshu.gmailapp.retrofit

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Products(
    @SerialName(value = "clip")
    val clip: List<Product>,
    @SerialName(value = "monitor")
    val monitor: List<Product>,
    @SerialName(value = "monitor-pro")
    val monitorPro: List<Product>,
    @SerialName(value = "reflective-strip")
    val reflectiveStrip: List<Product>,
    @SerialName(value = "reflective_3T_strip")
    val reflective3TStrip: List<Product>,
    @SerialName(value = "replacement-monitor")
    val replacementMonitor: List<Product>,
    @SerialName(value = "transmissive-strip")
    val transmissiveStrip: List<Product>
)