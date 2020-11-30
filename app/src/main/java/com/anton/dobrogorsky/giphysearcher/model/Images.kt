package com.anton.dobrogorsky.giphysearcher.model

import com.anton.dobrogorsky.giphysearcher.model.content.FixedHeight
import com.google.gson.annotations.SerializedName

data class Images(@SerializedName("fixed_height") val fixedHeight: FixedHeight)