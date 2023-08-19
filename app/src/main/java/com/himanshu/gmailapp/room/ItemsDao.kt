package com.himanshu.gmailapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.himanshu.gmailapp.retrofit.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemsDao{
    // Save data to database
    // get all the data from database
    @Upsert
    suspend fun insert(item: Item)
    @Insert
    suspend fun insertAll(item: List<Item>)
    @Query("SELECT * FROM items")
    fun getItems(): Flow<List<Item>>

    @Query("DELETE FROM items")
    suspend fun deleteAll()
}
