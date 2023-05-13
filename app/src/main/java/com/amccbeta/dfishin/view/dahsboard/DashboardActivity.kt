package com.amccbeta.dfishin.view.dahsboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.amccbeta.dfishin.data.model.article.ArticleModel
import com.amccbeta.dfishin.data.model.article.ArticleSingleton
import com.amccbeta.dfishin.databinding.ActivityDashboardBinding
import com.amccbeta.dfishin.view.adapter.home.ArticleAdapter

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun recyclerShown(){
        binding.rvArticles.adapter = ArticleAdapter(ArticleSingleton.listLocation)
        binding.rvArticles.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}