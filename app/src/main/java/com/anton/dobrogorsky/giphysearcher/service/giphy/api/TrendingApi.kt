package com.anton.dobrogorsky.giphysearcher.service.giphy.api

import com.anton.dobrogorsky.giphysearcher.model.DataObject
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface TrendingApi {

    @GET("/v1/gifs/trending")
    fun trendingGif(@QueryMap configuration: Map<String, String>): Single<Response<DataObject>>

}