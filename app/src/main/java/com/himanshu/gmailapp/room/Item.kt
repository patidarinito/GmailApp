package com.himanshu.gmailapp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName

@Entity(tableName = "items")
class Item(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val buttonText: String,
    val checkoutUrl: String,
    val description: String,
    val discountedPrice: String,
    val imageUrl: String,
    val outOfStock: Boolean,
    val price: String,
    val productId: String,
    val shippingInfo: String,
    val title: String
)