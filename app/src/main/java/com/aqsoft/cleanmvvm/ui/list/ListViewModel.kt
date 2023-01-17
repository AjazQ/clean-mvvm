package com.aqsoft.cleanmvvm.ui.list

import androidx.lifecycle.MutableLiveData
import com.aqsoft.cleanmvvm.domain.model.Item

class ListViewModel(val item: Item) {

    private val TAG = ListViewModel::class.java.simpleName
    val itemData = MutableLiveData<Item>()

    init {
        itemData.value = item
    }
}
