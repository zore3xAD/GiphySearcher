package com.anton.dobrogorsky.giphysearcher.flow.search_gif

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anton.dobrogorsky.giphysearcher.R
import org.koin.android.viewmodel.ext.android.viewModel

class SearchGifFragment : Fragment() {

    companion object {
        fun newInstance() = SearchGifFragment()
    }

    private val viewModel: SearchGifViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_gif_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.searchGif()
    }

}