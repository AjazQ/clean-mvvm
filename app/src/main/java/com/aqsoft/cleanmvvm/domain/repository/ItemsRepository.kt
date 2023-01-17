package com.aqsoft.cleanmvvm.domain.repository

import com.aqsoft.cleanmvvm.domain.model.Item
import io.reactivex.Single

interface ItemsRepository {
    fun getItems(): Single<List<Item>>
}