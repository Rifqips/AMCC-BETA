package com.amccbeta.dfishin.view.fishtype

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.amccbeta.dfishin.R
import com.amccbeta.dfishin.databinding.ActivityFishTypeBinding
import com.amccbeta.dfishin.view.dahsboard.DashboardActivity
import com.amccbeta.dfishin.view.fishtype.fragment.FishTypeFragment
import com.amccbeta.dfishin.view.fishtype.fragment.NotificationFragment
import com.amccbeta.dfishin.view.fishtype.fragment.ProfileFragment
import com.amccbeta.dfishin.view.fishtype.fragment.WheaterFragment

class FishTypeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFishTypeBinding

    private val fragmentProfile = ProfileFragment()
    private val fragmentHome = FishTypeFragment()
    private val fragmentWheater = WheaterFragment()
    private val fragmentNotification = NotificationFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFishTypeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.background = null
        switchFragment(fragmentHome)
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menuHome -> switchFragment(fragmentHome)
                R.id.menuWheater -> switchFragment(fragmentWheater)
                R.id.menuNotification -> switchFragment(fragmentNotification)
                R.id.menuPerson -> switchFragment(fragmentProfile)
//                R.id.navigation_blank
            }
            true
        }
//        binding.fab.setOnClickListener {
//
//        }

        binding.ivBack.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
        }
    }
    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}