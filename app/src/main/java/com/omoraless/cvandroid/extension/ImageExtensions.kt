package com.omoraless.cvandroid.extension
import android.widget.ImageView
import com.squareup.picasso.Picasso

    fun ImageView.getImageByUrl(url: String) {
        Picasso.with(context).load(url).fit().centerCrop().into(this)
    }
