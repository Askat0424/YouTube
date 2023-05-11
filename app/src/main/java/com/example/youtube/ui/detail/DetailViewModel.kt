package com.example.youtube.ui.detail

import PlaylistItem
import androidx.lifecycle.LiveData
import com.example.youtube.App
import com.example.youtube.core.network.result.Resource
import com.example.youtube.core.ui.BaseViewModel

class DetailViewModel : BaseViewModel() {

    fun getPlaylistItems(playlistId: String): LiveData<Resource<PlaylistItem>> {
        return App().repository.getPlaylistItems(playlistId)
    }
}