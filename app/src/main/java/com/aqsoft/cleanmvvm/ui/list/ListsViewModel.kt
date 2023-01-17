package com.aqsoft.cleanmvvm.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aqsoft.cleanmvvm.domain.model.Item
import com.aqsoft.cleanmvvm.domain.usecase.GetItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class ListsViewModel @Inject constructor(private val getRemedyUseCase: GetItemsUseCase) :
    ViewModel() {
        val listReceivedLiveData = MutableLiveData<List<Item>>()
        val isLoaded =MutableLiveData<Boolean>()
        val listData =MutableLiveData<Item>()
    init {
        isLoaded.value = false
    }
    val item: Item? get() = listData.value
    fun set(item: Item)= run {  listData. value= item}

    fun loadData(){
        getRemedyUseCase.execute(
            onSuccess = {
                isLoaded.value=true
                listReceivedLiveData.value=it
            }
        , onError = {
            it.printStackTrace()
            }
        )
    }
}