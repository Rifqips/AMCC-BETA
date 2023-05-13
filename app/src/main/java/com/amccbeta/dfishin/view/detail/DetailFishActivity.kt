package com.amccbeta.dfishin.view.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.amccbeta.dfishin.data.model.article.ArticleSingleton
import com.amccbeta.dfishin.data.model.detailfish.DetailFishSingleton
import com.amccbeta.dfishin.data.storage.PreferencesClass
import com.amccbeta.dfishin.databinding.ActivityDetailBinding
import com.amccbeta.dfishin.databinding.ActivityDetailFishBinding
import com.amccbeta.dfishin.view.adapter.detailfish.DetailFishAdapter
import com.amccbeta.dfishin.view.adapter.home.ArticleAdapter
import com.amccbeta.dfishin.view.fishtype.FishTypeActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailFishActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailFishBinding
    private lateinit var preferences: PreferencesClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFishBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerShown()
        preferences = PreferencesClass(this)

        Glide.with(this)
            .load(preferences.getValue("url"))
            .apply(RequestOptions.circleCropTransform())
            .into(binding.ivUser)

        binding.ivBack.setOnClickListener {
            startActivity(Intent(this, FishTypeActivity::class.java))
        }
    }

    private fun recyclerShown(){
        binding.rvDetailFish.adapter = DetailFishAdapter(DetailFishSingleton.listDetail)
        binding.rvDetailFish.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}