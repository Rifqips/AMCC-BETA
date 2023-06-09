package com.amccbeta.dfishin.view.fishtype.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.amccbeta.dfishin.data.model.article.ArticleSingleton
import com.amccbeta.dfishin.data.model.notification.NotificationSingleton
import com.amccbeta.dfishin.databinding.FragmentNotificationBinding
import com.amccbeta.dfishin.view.adapter.home.ArticleAdapter
import com.amccbeta.dfishin.view.adapter.notification.NotificationAdapter

class NotificationFragment : Fragment() {

    private lateinit var binding: FragmentNotificationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerShown()
    }

    private fun recyclerShown(){
        binding.rvNotification.adapter = NotificationAdapter(NotificationSingleton.listNotification)
        binding.rvNotification.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
    }


}
