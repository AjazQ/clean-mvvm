package com.aqsoft.cleanmvvm.ui.list

import com.aqsoft.cleanmvvm.domain.model.Item

interface OnListAdapterListener {
    fun itemClicked( item: Item)
}