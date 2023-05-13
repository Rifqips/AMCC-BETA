package com.amccbeta.dfishin.view.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amccbeta.dfishin.databinding.ActivityDetailBinding
import com.amccbeta.dfishin.databinding.ActivityDetailFishBinding

class DetailFishActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailFishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFishBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}