package com.amccbeta.dfishin.view.dahsboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.amccbeta.dfishin.data.model.article.ArticleModel
import com.amccbeta.dfishin.data.model.article.ArticleSingleton
import com.amccbeta.dfishin.data.storage.PreferencesClass
import com.amccbeta.dfishin.databinding.ActivityDashboardBinding
import com.amccbeta.dfishin.view.adapter.home.ArticleAdapter
import com.amccbeta.dfishin.view.buyfeed.BuyFeedActivity
import com.amccbeta.dfishin.view.distribusi.DistribusiActivity
import com.amccbeta.dfishin.view.fishtype.FishTypeActivity
import com.amccbeta.dfishin.view.fishtype.fragment.FishTypeFragment
import com.amccbeta.dfishin.view.profile.ProfileActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDashboardBinding

    private lateinit var preferences: PreferencesClass
    private lateinit var mFirebaseInstance: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerShown()
        preferences = PreferencesClass(this)
        mFirebaseInstance = FirebaseDatabase.getInstance().reference
        binding.tvUser.text = preferences.getValue("username")

        Glide.with(this)
            .load(preferences.getValue("url"))
            .apply(RequestOptions.circleCropTransform())
            .into(binding.ivUser)

        binding.cvFirstType.setOnClickListener {
            startActivity(Intent(this, FishTypeActivity::class.java))
        }

        binding.cvDistribution.setOnClickListener{
            startActivity(Intent(this, DistribusiActivity::class.java))
        }

        binding.cvBuyFeed.setOnClickListener {
            startActivity(Intent(this, BuyFeedActivity::class.java))
        }

        binding.ivUser.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

    }

    private fun recyclerShown(){
        binding.rvArticles.adapter = ArticleAdapter(ArticleSingleton.listLocation)
        binding.rvArticles.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}