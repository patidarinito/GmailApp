package com.himanshu.gmailapp.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [Item::class],
    version = 1,
    exportSchema = true
)
abstract class ItemsDatabase : RoomDatabase(){
    abstract val itemsDao: ItemsDao
}