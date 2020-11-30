package com.anton.dobrogorsky.giphysearcher.service.giphy

import com.anton.dobrogorsky.giphysearcher.BuildConfig

class GiphyConfigurator(val apiKey: String, val lang: String) {

    private val API_KEY = "api_key"
    private val LANG = "lang"

    fun getConfig(): Map<String, String> {
        return HashMap<String, String>().apply {
            put(API_KEY, apiKey)
            put(LANG, lang)
        }
    }

}