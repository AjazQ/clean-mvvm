package com.aqsoft.cleanmvvm.ui

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

fun ImageView.loadImageFull(url: String?)=
    Picasso.get().load(url).into(this)

fun ImageView.loadImage(url: String, progressBar: ProgressBar)=
    Picasso.get()
        .load(url)
        .placeholder(android.R.color.white)
        .into(this, object : Callback {
            override fun onSuccess() {
                progressBar.visibility=View.GONE
            }

            override fun onError(e: Exception?) {
                e?.printStackTrace()
            }

        })