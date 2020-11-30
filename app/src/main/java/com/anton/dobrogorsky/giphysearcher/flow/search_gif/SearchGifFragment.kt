package com.anton.dobrogorsky.giphysearcher.flow.search_gif

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import com.anton.dobrogorsky.giphysearcher.R
import com.anton.dobrogorsky.giphysearcher.databinding.SearchGifFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class SearchGifFragment : Fragment() {

    companion object {
        fun newInstance() = SearchGifFragment()
    }

    private lateinit var binding: SearchGifFragmentBinding
    private val viewModel: SearchGifViewModel by viewModel()

    private lateinit var gifAdapter: GifAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SearchGifFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        gifAdapter = GifAdapter()
        binding.gifRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            adapter = gifAdapter
        }
        viewModel.searchGifSuccess.observe(this, { data ->
            gifAdapter.dataList = data
        })
    }

}