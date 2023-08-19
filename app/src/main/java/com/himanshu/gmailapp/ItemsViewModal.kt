package com.himanshu.gmailapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.himanshu.gmailapp.retrofit.Product
import com.himanshu.gmailapp.retrofit.ShopApi
import com.himanshu.gmailapp.retrofit.ShopApiService
import com.himanshu.gmailapp.room.Item
import com.himanshu.gmailapp.room.ItemsDao
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.io.IOException


class ItemsViewModalFactory(private val itemsDao: ItemsDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemsViewModal::class.java)) {
            return ItemsViewModal(itemsDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
class ItemsViewModal(private val itemsDao: ItemsDao) : ViewModel() {
    // get data from database
    init {
        viewModelScope.launch {
            try {
                itemsDao.deleteAll()
                delay(5000)
                val productItems = ShopApi.retrofitService.getItems()
                val listOfProducts = listOf<List<Product>>(
                    productItems.products.monitor,
                    productItems.products.monitorPro,
                    productItems.products.reflectiveStrip,
                    productItems.products.transmissiveStrip,
                    productItems.products.reflective3TStrip
                )
                listOfProducts.forEach{
                    it.forEach {item->
                        val newItem = Item(
                            buttonText = item.buttonText,
                            checkoutUrl = item.checkoutUrl,
                            description = item.description,
                            discountedPrice = item.discountedPrice,
                            imageUrl = item.imageUrl,
                            outOfStock = item.outOfStock,
                            price = item.price,
                            productId = item.productId,
                            shippingInfo = item.shippingInfo,
                            title = item.title
                        )
                        itemsDao.insert(newItem)
                    }
                }
            }
            catch (e : IOException){
                println("Error in saving $e")
            }

        }
    }
    private val _allWords: Flow<List<Item>> = itemsDao.getItems()
    val allWords: StateFlow<List<Item>> = _allWords
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList<Item>())

}