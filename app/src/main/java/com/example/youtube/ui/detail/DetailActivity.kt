package com.example.youtube.ui.detail

import android.os.Build.ID
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.youtube.base.BaseActivity
import com.example.youtube.databinding.ActivityDetailBinding


class DetailActivity() : BaseActivity<ActivityDetailBinding, DetailViewModel>() {
    override val viewModel: DetailViewModel by lazy {
        ViewModelProvider(this)[DetailViewModel::class.java]
    }

    override fun inflateViewBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        super.initViews()
        getExtra()
    }

    private fun getExtra() {
        val getIntent =
            intent.getStringExtra(ID)
        Toast.makeText(this, getIntent, Toast.LENGTH_SHORT).show()
    }


}