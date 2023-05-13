package com.amccbeta.dfishin.view.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.amccbeta.dfishin.data.storage.PreferencesClass
import com.amccbeta.dfishin.databinding.ActivitySplashBinding
import com.amccbeta.dfishin.view.auth.AuthActivity
import com.amccbeta.dfishin.view.dahsboard.DashboardActivity
import com.amccbeta.dfishin.view.onboarding.OnboardingActivity
import com.google.android.gms.common.data.DataHolder

class SplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding
    private lateinit var preferences: PreferencesClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        preferences = PreferencesClass(this)

        Handler(Looper.myLooper()!!).postDelayed({
            if (preferences.sharedPref.getString("username","") == "" && preferences.sharedPref.getString("password", "") == "") {
                val intentLogin = Intent(this, AuthActivity::class.java)
                startActivity(intentLogin)
            } else {
                val intent = Intent(this,DashboardActivity::class.java)
                intent.putExtra("username", preferences.sharedPref.getString("username",""))
                startActivity(intent)
            }
        },3000)
        setContentView(binding.root)

    }
}