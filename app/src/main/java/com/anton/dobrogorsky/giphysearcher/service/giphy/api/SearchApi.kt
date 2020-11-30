package com.anton.dobrogorsky.giphysearcher.service.giphy.api

import com.anton.dobrogorsky.giphysearcher.model.DataObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface SearchApi {

    @GET("/v1/gifs/search")
    suspend fun searchGif(@QueryMap configuration: Map<String, String>,
                  @Query("q") q: String): Response<DataObject>

}