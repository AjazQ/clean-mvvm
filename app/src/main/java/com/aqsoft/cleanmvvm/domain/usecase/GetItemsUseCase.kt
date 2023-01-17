package com.aqsoft.cleanmvvm.domain.usecase

import com.aqsoft.cleanmvvm.domain.model.Item
import com.aqsoft.cleanmvvm.domain.repository.ItemsRepository
import com.aqsoft.cleanmvvm.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetItemsUseCase @Inject constructor(
    private val repository: ItemsRepository
):SingleUseCase<List<Item>> (){
    override fun buildUseCaseSingle(): Single<List<Item>> {
        return repository.getItems()
    }

}