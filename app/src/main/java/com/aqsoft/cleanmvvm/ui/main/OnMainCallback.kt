package com.aqsoft.cleanmvvm.ui.main

import com.aqsoft.cleanmvvm.domain.model.Item

interface OnMainCallback {
    fun navigateItemDetails(item: Item)
}