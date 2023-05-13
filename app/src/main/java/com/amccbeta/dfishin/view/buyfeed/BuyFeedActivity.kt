package com.amccbeta.dfishin.view.buyfeed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.amccbeta.dfishin.data.model.buyfeed.BuyFeedSingleton
import com.amccbeta.dfishin.data.model.distribusi.DistribusiSingleton
import com.amccbeta.dfishin.databinding.ActivityBuyFeedBinding
import com.amccbeta.dfishin.view.adapter.buyfeed.BuyFeedAdapter
import com.amccbeta.dfishin.view.adapter.distribusi.DistribusiAdapter
import com.amccbeta.dfishin.view.dahsboard.DashboardActivity

class BuyFeedActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBuyFeedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuyFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerShown()

        binding.ivBack.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
        }
    }



    private fun recyclerShown(){
        val layoutManager = GridLayoutManager(this, 2)

        binding.rvDistribusi.layoutManager = layoutManager
        binding.rvDistribusi.adapter = BuyFeedAdapter(BuyFeedSingleton.listBuyFeed)
    }

}