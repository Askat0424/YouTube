package com.example.youtube.ui.playlists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtube.core.ui.BaseViewModel
import com.example.youtube.data.remote.ApiService
import com.example.youtube.core.network.RetrofitClient
import com.geektech.youtubeapi.data.remote.model.Playlist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistsViewModel: BaseViewModel() {

    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    fun playlists() : LiveData<Playlist> {
        return getPlaylists()
    }

    fun getPlaylists() : LiveData<Playlist> {
        val data = MutableLiveData<Playlist>()

        apiService.getPlaylists(com.example.youtube.BuildConfig.API_KEY, "contentDetails,snippet", "UCWOA1ZGywLbqmigxE4Qlvuw",30)
            .enqueue(object : Callback<Playlist>{
                override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                    if (response.isSuccessful){
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<Playlist>, t: Throwable) {
                    print(t.stackTrace)
                }
            })

        return data
    }
}