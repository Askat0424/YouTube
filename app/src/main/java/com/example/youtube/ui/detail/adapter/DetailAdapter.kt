package com.example.youtube.ui.detail.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube.databinding.ItemDetailBinding
import com.example.youtube.loadImage
import com.geektech.youtubeapi.data.remote.model.Playlist

class DetailAdapter() : RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {

    private var list = ArrayList<PlaylistItem.Item>()

    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: List<Playlist.Item>) {
        this.list = list as ArrayList<PlaylistItem.Item>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(
            ItemDetailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class DetailViewHolder(private val binding: ItemDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PlaylistItem.Item) {
            with(binding) {
                tvVideoName.text = item.snippet?.title
                tvTime.text = item.snippet?.publishedAt
                ivVideo.loadImage(item.snippet?.thumbnails?.standard?.url!!)
            }
        }
    }
}