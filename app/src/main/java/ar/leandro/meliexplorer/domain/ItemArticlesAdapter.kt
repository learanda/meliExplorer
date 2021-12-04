package ar.leandro.meliexplorer.domain

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.leandro.meliexplorer.R
import ar.leandro.meliexplorer.databinding.ItemArticleBinding
import ar.leandro.meliexplorer.domain.model.Article
import com.squareup.picasso.Picasso


class ItemArticlesAdapter(var articles: List<Article>) : RecyclerView.Adapter<ItemArticlesAdapter.ItemArticlesHolder>() {

    class ItemArticlesHolder(val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(articles: Article) {
            binding.tvTitle.text = articles.title
            binding.tvPrice.text = articles.price.toString()
            Picasso.get()
                .load(articles.thumbnail)
                .into(binding.ivPicture)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemArticlesHolder {
        val binding = ItemArticleBinding
            .inflate(LayoutInflater.from(parent.context),parent, false)
        return ItemArticlesHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemArticlesHolder, position: Int) {
        holder.bind(articles[position])
    }

    override fun getItemCount(): Int = articles.size

    fun setListData(data: List<Article>) {
        this.articles = data
        this.notifyDataSetChanged()

    }
}