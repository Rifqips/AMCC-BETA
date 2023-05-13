package com.amccbeta.dfishin.view.adapter.detailfish

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amccbeta.dfishin.data.model.detailfish.DetailFishModel
import com.amccbeta.dfishin.databinding.ItemArticlesBinding

class DetailFishAdapter(private var fishDetail : ArrayList<DetailFishModel>): RecyclerView.Adapter<DetailFishAdapter.ListViewHolder>() {

    class ListViewHolder (val binding : ItemArticlesBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        var view = ItemArticlesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.binding.ivArticles.setImageResource(fishDetail[position].pict)
        holder.binding.tvTittle.text = fishDetail[position].title
        holder.binding.tvSubTittle.text = fishDetail[position].content

//        holder.binding.itemArticles.setOnClickListener {
//            val intent = Intent(it.context, DetailActivity::class.java)
//            intent.putExtra("gambar", article[position].pict)
//            intent.putExtra("title", article[position].title)
//            intent.putExtra("date", article[position].content)
//            it.context.startActivity(intent)
//
//        }
    }

    fun setDataArticle(DetailFishList : ArrayList<DetailFishModel>){
        this.fishDetail = DetailFishList
    }

    override fun getItemCount(): Int {
        return fishDetail.size
    }

}