package com.example.youtube.ui.playlists

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube.databinding.ItemPlayListBinding
import com.example.youtube.loadImage
import com.geektech.youtubeapi.data.remote.model.Playlist


class PlaylistsAdapter(private val onClick: (Playlist.Item) -> Unit) :
    RecyclerView.Adapter<PlaylistsAdapter.PlaylistsViewHolder>() {

    private var list = ArrayList<Playlist.Item>()

    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: List<Playlist.Item>) {
        this.list = list as ArrayList<Playlist.Item>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistsViewHolder {
        return PlaylistsViewHolder(
            ItemPlayListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlaylistsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class PlaylistsViewHolder(private val binding: ItemPlayListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Playlist.Item) {
            with(binding) {
                tvPlaylistName.text = item.snippet?.title
                tvNumberOfVideos.text = item.contentDetails?.itemCount.toString() + " video series"
                ivPlaylist.loadImage(item.snippet?.thumbnails?.default?.url!!)
                cvPlaylist.setOnClickListener {
                    onClick.invoke(item)
                }
            }
        }
    }
}