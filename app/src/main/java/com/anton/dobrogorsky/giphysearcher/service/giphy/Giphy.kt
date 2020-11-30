package com.anton.dobrogorsky.giphysearcher.service.giphy

import androidx.lifecycle.LiveData
import com.anton.dobrogorsky.giphysearcher.service.giphy.api.SearchApi

class Giphy(
    private val configurator: GiphyConfigurator,
    private val searchApi: SearchApi) {


    suspend fun searchGif(query: String) = searchApi.searchGif(configurator.getConfig(), query)

}