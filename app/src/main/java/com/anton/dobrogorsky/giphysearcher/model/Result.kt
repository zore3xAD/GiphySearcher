package com.anton.dobrogorsky.giphysearcher.model

import java.lang.Exception

sealed class Result<out T : Any> {

    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val code: Int, val errorMessage: String) : Result<Nothing>()

}