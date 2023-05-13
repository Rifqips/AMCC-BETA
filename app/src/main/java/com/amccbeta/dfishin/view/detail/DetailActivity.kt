package com.amccbeta.dfishin.view.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amccbeta.dfishin.databinding.ActivityDetailBinding
import com.amccbeta.dfishin.view.dahsboard.DashboardActivity

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getItem()

        binding.ivBack.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
        }

    }

    fun getItem(){
        val item = intent
        val gambar = item.getIntExtra("gambar",0)
        val title = item?.getStringExtra("title")
        val date = item?.getStringExtra("date")
        val description = item?.getStringExtra("description")
        val number = item?.getStringExtra("number")

        binding.ivDetail.setImageResource(gambar)
        binding.tvTittle.text = title
        binding.tvDate.text = date
        binding.tvDescription.text = description
    }
}