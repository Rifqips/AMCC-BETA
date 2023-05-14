package com.amccbeta.dfishin.view.profile

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.amccbeta.dfishin.data.storage.PreferencesClass
import com.amccbeta.dfishin.databinding.ActivityProfileBinding
import com.amccbeta.dfishin.view.auth.AuthActivity
import com.amccbeta.dfishin.view.dahsboard.DashboardActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProfileBinding
    private lateinit var preferences: PreferencesClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferences = PreferencesClass(this)
        binding.edName.hint = preferences.getValue("username")
        binding.edEmail.hint = preferences.getValue("email")
        binding.edTelepon.hint = preferences.getValue("telepon")
        binding.edPassword.hint = preferences.getValue("password")

        Glide.with(this)
            .load(preferences.getValue("url"))
            .apply(RequestOptions.circleCropTransform())
            .into(binding.ivDetail)

        binding.ivDetail.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
        }

        binding.btnAction.setOnClickListener {
            alert()
        }

    }

    private fun alert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Logout")
        builder.setMessage("Do you want to logout ?")
        builder.setNegativeButton("Cancel"){ _, which ->
            Toast.makeText(this,"Cancel", Toast.LENGTH_LONG).show()
        }

        builder.setPositiveButton("Yes"){ _, which->
            val mEditor = preferences.sharedPref.edit()
            mEditor.remove("username").apply()
            mEditor.remove("email").apply()
            mEditor.clear()
            val intentLogin = Intent(this, AuthActivity::class.java)
            startActivity(intentLogin)
            finishAffinity()
            Toast.makeText(this,"Anda Logout", Toast.LENGTH_LONG).show()
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()

    }
}