package com.amccbeta.dfishin.view.adapter.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amccbeta.dfishin.data.model.article.ArticleModel
import com.amccbeta.dfishin.databinding.ItemArticlesBinding
import com.amccbeta.dfishin.view.detail.DetailActivity

class ArticleAdapter(private var article : ArrayList<ArticleModel>): RecyclerView.Adapter<ArticleAdapter.ListViewHolder>() {

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
        holder.binding.ivArticles.setImageResource(article[position].pict)
        holder.binding.tvTittle.text = article[position].title
        holder.binding.tvSubTittle.text = article[position].subTitle
        holder.binding.tvDate.text = article[position].date
        holder.binding.tvDescription.text = article[position].description

        holder.binding.itemArticles.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra("gambar", article[position].pict)
            intent.putExtra("title", article[position].title)
            intent.putExtra("date", article[position].date)
            intent.putExtra("subtitle", article[position].subTitle)
            intent.putExtra("description", article[position].description)
            it.context.startActivity(intent)

        }
    }

    fun setDataArticle(ArticleList : ArrayList<ArticleModel>){
        this.article = ArticleList
    }

    override fun getItemCount(): Int {
        return article.size
    }

}