package com.aqsoft.cleanmvvm.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Items")
data class ItemEntity(
    @PrimaryKey var id: Long,
    var CommonName: String,
    var BotanicalName: String,
    var Memo: String
)
