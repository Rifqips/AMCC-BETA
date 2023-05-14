package com.amccbeta.dfishin.view.adapter.notification

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amccbeta.dfishin.data.model.notification.NotificationModel
import com.amccbeta.dfishin.databinding.ItemNotificationBinding

class NotificationAdapter(private var notification : ArrayList<NotificationModel>): RecyclerView.Adapter<NotificationAdapter.ListViewHolder>() {

    class ListViewHolder (val binding : ItemNotificationBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        var view = ItemNotificationBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.binding.tvDescription.text = notification[position].subTitle
        holder.binding.tvSubTittle.text = notification[position].title
        holder.binding.tvDate.text = notification[position].date
    }

    fun setDataArticle(NotificationList : ArrayList<NotificationModel>){
        this.notification = NotificationList
    }

    override fun getItemCount(): Int {
        return notification.size
    }

}