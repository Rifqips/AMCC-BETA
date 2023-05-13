package com.amccbeta.dfishin.view.fishtype.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amccbeta.dfishin.R
import com.amccbeta.dfishin.databinding.FragmentProfileBinding
import com.amccbeta.dfishin.databinding.FragmentWheaterBinding

class WheaterFragment : Fragment() {

    private lateinit var binding: FragmentWheaterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWheaterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}