package com.aqsoft.cleanmvvm.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aqsoft.cleanmvvm.data.source.local.dao.ItemDao
import com.aqsoft.cleanmvvm.data.source.local.entity.ItemEntity

@Database(entities = [ItemEntity::class], version = 1, exportSchema = false)
abstract class ApplicationDatabase: RoomDatabase() {
    abstract val itemDao: ItemDao

    companion object{
        const val DATABASE_NAME = "ItemsDatabase.db"
    }

}