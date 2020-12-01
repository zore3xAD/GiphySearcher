package com.anton.dobrogorsky.giphysearcher.service.giphy

import com.anton.dobrogorsky.giphysearcher.model.DataObject
import com.anton.dobrogorsky.giphysearcher.model.Result
import com.anton.dobrogorsky.giphysearcher.service.giphy.api.TrendingApi
import com.anton.dobrogorsky.giphysearcher.service.giphy.api.SearchApi
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class Giphy(
    private val configurator: GiphyConfigurator,
    private val searchApi: SearchApi,
    private val trendingApi: TrendingApi
) {


    fun randomGif() = trendingApi.trendingGif(configurator.getConfig())
        .map { response -> mapResponse(response) }
        .subscribeOn(Schedulers.io())


    fun searchGif(query: String) = searchApi.searchGif(configurator.getConfig(), query)
        .map { response -> mapResponse(response) }
        .subscribeOn(Schedulers.io())

    private fun mapResponse(response: Response<DataObject>) = when (response.code()) {
        200 -> Result.Success(response.body()?.data ?: emptyList())
        else -> Result.Error(response.code(), response.message())
    }
}