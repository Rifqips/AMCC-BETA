package com.amccbeta.dfishin.view.fishtype.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amccbeta.dfishin.R
import com.amccbeta.dfishin.databinding.FragmentFishTypeBinding
import com.amccbeta.dfishin.view.detail.DetailFishActivity

class FishTypeFragment : Fragment() {

    private lateinit var binding : FragmentFishTypeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFishTypeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cvCatfish.setOnClickListener {
            startActivity(Intent(requireActivity(), DetailFishActivity::class.java))
        }
    }
}