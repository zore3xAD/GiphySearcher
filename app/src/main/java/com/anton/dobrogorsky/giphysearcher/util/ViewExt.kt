package com.anton.dobrogorsky.giphysearcher.util

import android.widget.ImageView
import com.anton.dobrogorsky.giphysearcher.di.GlideInstance

fun ImageView.loadGif(url: String) {
    GlideInstance.glide
        .asGif()
        .load(url)
        .into(this)
}