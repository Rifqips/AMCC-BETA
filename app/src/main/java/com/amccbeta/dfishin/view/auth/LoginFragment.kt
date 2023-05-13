package com.amccbeta.dfishin.view.auth

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.amccbeta.dfishin.R
import com.amccbeta.dfishin.data.model.user.User
import com.amccbeta.dfishin.data.storage.PreferencesClass
import com.amccbeta.dfishin.databinding.FragmentLoginBinding
import com.amccbeta.dfishin.view.dahsboard.DashboardActivity
import com.google.firebase.database.*
import java.sql.Connection
import java.sql.Statement

class LoginFragment : Fragment() {
    companion object {
        fun newInstance() = LoginFragment()
    }


    private lateinit var binding: FragmentLoginBinding
    lateinit var mDatabase : DatabaseReference
    lateinit var preference : PreferencesClass

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
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mDatabase = FirebaseDatabase.getInstance().getReference("user")
        preference = PreferencesClass(requireActivity())

        binding.btnAction.setOnClickListener{
            preference.setValue("username",binding.edUsername.text.toString())
            if ( binding.edUsername.equals("")){
                binding.edUsername.error = "Silakan tulis username Anda"
                binding.edUsername.requestFocus() // agar cursor fokus ke username
            }else if ( binding.edPassword.equals("")){
                binding.edPassword.error = "Silakan tulis password Anda"
                binding.edPassword.requestFocus() // agar cursor fokus ke username
            } else{

                var statusUsername = binding.edUsername.text?.indexOf(".")
                if (statusUsername!! >=0) {
                    binding.edUsername.error = "Silahkan tulis Email Anda tanpa ."
                    binding.edUsername.requestFocus()
                } else {
                    pushLogin(binding.edUsername.text.toString(), binding.edPassword.text.toString())
                }


            }
        }

        binding.btnRegister.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.container, RegisterFragment(), RegisterFragment::class.java.simpleName)
                /* shared element transition to main activity */
                addSharedElement(binding.edUsername, "email")
                addSharedElement(binding.edPassword, "password")
                commit()
            }
        }
    }

    private fun pushLogin(iUsername: String, iPassword: String) {
        mDatabase.child(iUsername).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val user = dataSnapshot.getValue(User::class.java)
                if (user == null){
                    Toast.makeText(requireActivity(), "User tidak ditemukan", Toast.LENGTH_LONG).show()
                }
                else {

                    if(user.password.equals(iPassword)){

                        preference.setValue("user", user.username.toString())
                        preference.setValue("email", user.email.toString())
                        preference.setValue("status", "1")

                        var intent = Intent(requireActivity(), DashboardActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(requireActivity(), "Password Anda salah", Toast.LENGTH_LONG).show()
                    }

                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(requireActivity(), databaseError.message, Toast.LENGTH_LONG).show()
            }
        })
    }

}