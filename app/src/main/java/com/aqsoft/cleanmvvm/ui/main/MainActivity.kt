package com.aqsoft.cleanmvvm.ui.main

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import com.aqsoft.cleanmvvm.R
import com.aqsoft.cleanmvvm.domain.model.Item
import com.aqsoft.cleanmvvm.ui.list.ListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() , OnMainCallback{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState==null) {
            navigationToItemsPage()
        }
    }
    private fun navigationToItemsPage(){
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.main_container,
                ListFragment.newInstance(),
                ListFragment.FRAGMENT_NAME
            ).commitAllowingStateLoss()
    }

    override fun navigateItemDetails(item: Item) {
        Toast.makeText(this,item.BotanicalName,LENGTH_SHORT).show()
    }
}