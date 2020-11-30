package com.anton.dobrogorsky.giphysearcher.flow.search_gif

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.anton.dobrogorsky.giphysearcher.R
import com.anton.dobrogorsky.giphysearcher.model.GifObject
import com.anton.dobrogorsky.giphysearcher.util.loadGif

class GifAdapter() : RecyclerView.Adapter<GifAdapter.ViewHolder>() {

    var dataList: List<GifObject> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(
        val view: View,
        private val imageView: ImageView = view.findViewById(R.id.imageViewGif)
    ) : RecyclerView.ViewHolder(view) {

        fun bind(item: GifObject) {
            imageView.loadGif(item.images.fixedHeight.url)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_gif, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }
}