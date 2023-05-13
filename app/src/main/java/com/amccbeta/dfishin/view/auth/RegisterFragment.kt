package com.amccbeta.dfishin.view.auth

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amccbeta.dfishin.R
import com.amccbeta.dfishin.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

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
        binding.btnLogin.setOnClickListener {
            switchLogin()
        }

//        binding.btnAction.setOnClickListener {
//            val username = binding.edName.text.toString().trim()
//            val useremail = binding.edEmail.text.toString().trim()
//            val password = binding.edPassword.text.toString().trim()
//            val confPassword = binding.edConfirmPassword.text.toString().trim()
//            if (DatabaseHandler.authenticateUser(username,useremail, password)) {
//                // Autentikasi berhasil, lakukan tindakan yang sesuai (navigasi ke halaman utama, dll.)
//                Toast.makeText(requireActivity(), "Login successful!", Toast.LENGTH_SHORT).show()
//            } else {
//                // Autentikasi gagal, tampilkan pesan kesalahan
//                Toast.makeText(requireActivity(), "Invalid", Toast.LENGTH_SHORT).show()
//            }
//        }

    }

    private fun switchLogin() {
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.container, LoginFragment(), LoginFragment::class.java.simpleName)
            /* shared element transition to main activity */
            addSharedElement(binding.labelAuth, "auth")
            addSharedElement(binding.edEmail, "email")
            addSharedElement(binding.edPassword, "password")
            addSharedElement(binding.containerMisc, "misc")
            commit()
        }
    }
}