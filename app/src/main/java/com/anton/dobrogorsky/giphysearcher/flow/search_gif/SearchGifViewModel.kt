package com.anton.dobrogorsky.giphysearcher.flow.search_gif

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anton.dobrogorsky.giphysearcher.model.GifObject
import com.anton.dobrogorsky.giphysearcher.model.Result
import com.anton.dobrogorsky.giphysearcher.service.giphy.Giphy
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class SearchGifViewModel(val giphy: Giphy) : ViewModel() {

    private val TAG = SearchGifViewModel::class.java.simpleName

    private val _searchGifSuccess: MutableLiveData<List<GifObject>> = MutableLiveData()
    val searchGifSuccess = _searchGifSuccess

    init {
        searchGif()
    }

    fun searchGif() {
        giphy.searchGif("smile")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    when (result) {
                        is Result.Success -> {
                            Log.i(TAG, "result success with data length: ${result.data.size}")
                            _searchGifSuccess.value = result.data
                        }
                        is Result.Error -> {
                            Log.i(TAG, "result error with code: ${result.code}, ${result.errorMessage}")
                        }
                    }
                }, {
                    Log.i(TAG, it.message ?: "Something was wrong")
                })
    }


}