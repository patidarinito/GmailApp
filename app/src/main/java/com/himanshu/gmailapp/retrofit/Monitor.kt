package com.himanshu.gmailapp.retrofit

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Product(
    @SerialName(value = "button_text")
    val buttonText: String,
    @SerialName(value = "checkout_url")
    val checkoutUrl: String,
    @SerialName(value = "description")
    val description: String,
    @SerialName(value = "discounted_price")
    val discountedPrice: String,
    @SerialName(value = "image_url")
    val imageUrl: String,
    @SerialName(value = "out_of_stock")
    val outOfStock: Boolean,
    @SerialName(value = "price")
    val price: String,
    @SerialName(value = "product_id")
    val productId: String,
    @SerialName(value = "shipping_info")
    val shippingInfo: String,
    @SerialName(value = "title")
    val title: String
)