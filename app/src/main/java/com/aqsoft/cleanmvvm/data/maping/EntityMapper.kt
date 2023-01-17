package com.aqsoft.cleanmvvm.data.maping

import com.aqsoft.cleanmvvm.data.source.local.entity.ItemEntity
import com.aqsoft.cleanmvvm.domain.model.Item

fun Item.toEntity()=ItemEntity(
    id= id,
    CommonName=CommonName,
    BotanicalName=BotanicalName,
    Memo=Memo
)