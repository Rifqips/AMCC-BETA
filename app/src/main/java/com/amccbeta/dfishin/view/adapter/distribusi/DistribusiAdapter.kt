package com.amccbeta.dfishin.view.adapter.distribusi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amccbeta.dfishin.data.model.detailfish.DetailFishModel
import com.amccbeta.dfishin.data.model.distribusi.DistribusiModel
import com.amccbeta.dfishin.databinding.ItemDetailFishBinding
import com.amccbeta.dfishin.databinding.ItemDistribusiBinding

class DistribusiAdapter(private var fishDetail : ArrayList<DistribusiModel>): RecyclerView.Adapter<DistribusiAdapter.ListViewHolder>() {

    class ListViewHolder (val binding : ItemDistribusiBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        var view = ItemDistribusiBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.binding.ivDistribusi.setImageResource(fishDetail[position].pict)
        holder.binding.tvDistribusi.text = fishDetail[position].title

    }

    fun setDataArticle(DistribusiFish : ArrayList<DistribusiModel>){
        this.fishDetail = DistribusiFish
    }

    override fun getItemCount(): Int {
        return fishDetail.size
    }

}