package com.anton.dobrogorsky.giphysearcher.flow.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anton.dobrogorsky.giphysearcher.R
import com.anton.dobrogorsky.giphysearcher.flow.search_gif.SearchGifFragment
import com.anton.dobrogorsky.giphysearcher.util.replaceFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(SearchGifFragment.newInstance())
    }
}