package com.anton.dobrogorsky.giphysearcher.service.giphy

import com.anton.dobrogorsky.giphysearcher.model.Result
import com.anton.dobrogorsky.giphysearcher.service.giphy.api.SearchApi
import io.reactivex.rxjava3.schedulers.Schedulers

class Giphy(
    private val configurator: GiphyConfigurator,
    private val searchApi: SearchApi
) {


    fun searchGif(query: String) = searchApi.searchGif(configurator.getConfig(), query)
        .map { response ->
            when (response.code()) {
                200 -> Result.Success(response.body()?.data ?: emptyList())
                else -> Result.Error(response.code(), response.message())
            }
        }.subscribeOn(Schedulers.io())
}