package com.amccbeta.dfishin.view.auth

import android.app.Activity
import android.app.ProgressDialog
import android.content.ContentResolver
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isGone
import com.amccbeta.dfishin.R
import com.amccbeta.dfishin.data.model.user.User
import com.amccbeta.dfishin.data.storage.PreferencesClass
import com.amccbeta.dfishin.databinding.FragmentRegisterBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.gms.cast.framework.media.ImagePicker
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.util.*


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    lateinit var preferences : PreferencesClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val animation = TransitionInflater.from(requireContext())
            .inflateTransition(android.R.transition.move)
        sharedElementEnterTransition = animation
        sharedElementReturnTransition = animation
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        preferences = PreferencesClass(requireContext())

        binding.btnLogin.setOnClickListener {
            switchLogin()
        }



        binding.btnAction.setOnClickListener {
                preferences.setValue("username", binding.edName.text.toString())
                preferences.setValue("telepon", binding.edTelepon.text.toString())
                preferences.setValue("email", binding.edEmail.text.toString())
                preferences.setValue("password", binding.edPassword.text.toString())

            if ( binding.edName.equals("")){
                binding.edName.error = "Silakan isi username Anda"
                binding.edName.requestFocus()
            } else if (binding.edTelepon.equals("")){
                binding.edTelepon.error = "Silakan isi no telepon Anda"
                binding.edTelepon.requestFocus()
            } else if (binding.edPassword.equals("")){
                binding.edPassword.error = "Silakan isi password Anda"
                binding.edPassword.requestFocus()
            }else if (binding.edEmail.equals("")){
                binding.edEmail.error = "Silakan isi nama Anda"
                binding.edEmail.requestFocus()
            } else {
                val statusUsername = binding.edName.text!!.indexOf(".")
                if (statusUsername >=0) {
                    binding.edName.error = "Silahkan tulis Username Anda tanpa ."
                    binding.edName.requestFocus()
                }
            }

            startActivity(Intent(requireActivity(),UploadActivity::class.java ))

        }

    }

    private fun saveUsername(sUsername: String, sPassword: String,  sEmail: String, sTelepon: String, sUrl: String) {
        val user = User()
        user.username = sUsername
        user.password = sPassword
        user.email = sEmail
        user.email = sEmail
        user.telepon = sTelepon
        user.url = sUrl

    }



    private fun switchLogin() {
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.container, LoginFragment(), LoginFragment::class.java.simpleName)
            /* shared element transition to main activity */
            addSharedElement(binding.labelAuth, "auth")
            addSharedElement(binding.edEmail, "email")
            addSharedElement(binding.edPassword, "password")
            addSharedElement(binding.edTelepon, "telepon")
            commit()
        }
    }
}