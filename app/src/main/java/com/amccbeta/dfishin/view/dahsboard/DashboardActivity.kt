package com.amccbeta.dfishin.view.dahsboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amccbeta.dfishin.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}