package com.aqsoft.cleanmvvm.data.source.local.dao

import androidx.room.*
import com.aqsoft.cleanmvvm.data.source.local.entity.ItemEntity

@Dao
interface ItemDao {
    @Insert(onConflict =OnConflictStrategy.REPLACE)
    fun insert(item: ItemEntity): Long

    @Query("SELECT * FROM Items")
    fun getAll(): MutableList<ItemEntity>

    @Delete
    fun delete(remedy: ItemEntity)

    @Query("DELETE FROM Items")
    fun deleteAll()

    @Query("SELECT * FROM Items WHERE id=:id")
    fun getById(id: Long): ItemEntity?

    @Update
    fun update(entity: ItemEntity)




}