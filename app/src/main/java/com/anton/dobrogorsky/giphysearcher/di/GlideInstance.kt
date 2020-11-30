package com.anton.dobrogorsky.giphysearcher.di

import com.bumptech.glide.RequestManager
import org.koin.core.KoinComponent
import org.koin.core.inject

object GlideInstance: KoinComponent {

    val glide: RequestManager by inject()

}