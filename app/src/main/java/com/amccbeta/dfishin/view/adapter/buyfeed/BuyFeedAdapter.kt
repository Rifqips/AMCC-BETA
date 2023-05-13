package com.amccbeta.dfishin.view.adapter.buyfeed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amccbeta.dfishin.data.model.buyfeed.BuyFeedModel
import com.amccbeta.dfishin.data.model.distribusi.DistribusiModel
import com.amccbeta.dfishin.databinding.ItemBuyfeedBinding
import com.amccbeta.dfishin.databinding.ItemDistribusiBinding

class BuyFeedAdapter(private var buyFeed : ArrayList<BuyFeedModel>): RecyclerView.Adapter<BuyFeedAdapter.ListViewHolder>() {

    class ListViewHolder (val binding : ItemBuyfeedBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        var view = ItemBuyfeedBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.binding.ivBuyFeed.setImageResource(buyFeed[position].pict)
        holder.binding.tvBuyfeed.text = buyFeed[position].title
        holder.binding.tvHarga.text = buyFeed[position].subTitle

    }

    fun setDataArticle(BuyFeed : ArrayList<BuyFeedModel>){
        this.buyFeed = BuyFeed
    }

    override fun getItemCount(): Int {
        return buyFeed.size
    }

}