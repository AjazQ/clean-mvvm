package com.aqsoft.cleanmvvm.data.repository

import com.aqsoft.cleanmvvm.data.source.remote.RetrofitService
import com.aqsoft.cleanmvvm.domain.model.Item
import com.aqsoft.cleanmvvm.domain.repository.ItemsRepository
import io.reactivex.Single

class ItemRepositoryImp (
    private val retrofitService: RetrofitService
    ):ItemsRepository{
        override fun getItems(): Single<List<Item>> {
            return retrofitService.getRemedies()
        }
    }
