package com.amccbeta.dfishin.view.distribusi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.amccbeta.dfishin.data.model.article.ArticleSingleton
import com.amccbeta.dfishin.data.model.distribusi.DistribusiSingleton
import com.amccbeta.dfishin.databinding.ActivityDistribusiBinding
import com.amccbeta.dfishin.view.adapter.distribusi.DistribusiAdapter
import com.amccbeta.dfishin.view.adapter.home.ArticleAdapter
import com.amccbeta.dfishin.view.dahsboard.DashboardActivity

class DistribusiActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDistribusiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDistribusiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerShown()

        binding.ivBack.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
        }
    }

    private fun recyclerShown(){
        val layoutManager = GridLayoutManager(this, 2)

        binding.rvDistribusi.layoutManager = layoutManager
        binding.rvDistribusi.adapter = DistribusiAdapter(DistribusiSingleton.listDistribusi)
    }

}