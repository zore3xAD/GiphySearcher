package com.anton.dobrogorsky.giphysearcher.flow.search_gif

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anton.dobrogorsky.giphysearcher.service.giphy.Giphy
import kotlinx.coroutines.launch

class SearchGifViewModel(val giphy: Giphy) : ViewModel() {


    fun searchGif() {
        viewModelScope.launch {
            val result = giphy.searchGif("burger")
            Log.i("SearchGif", result.code().toString())
        }
    }


}