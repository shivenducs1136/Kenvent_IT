package com.dsckiet.mvvmtask

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dsckiet.mvvmtask.model.Feeds
import com.squareup.picasso.Picasso


class FeedAdapter(private val context: Context): RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {
    private var collect:List<Feeds.Article> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.rec_view_item, parent, false)
        return FeedViewHolder(v)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val collect= collect[position]
        Picasso.with(context)
            .load(collect.urlToImage)
            .into(holder.feedimg)

        holder.feedtitle.text = collect.title

    }

    override fun getItemCount(): Int {
        return collect.size
    }

    class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val feedimg = itemView.findViewById<ImageView>(R.id.item_img)
        val feedtitle = itemView.findViewById<TextView>(R.id.item_txt)
        val feedcross = itemView.findViewById<ImageView>(R.id.item_cross)
    }

    fun setStateWiseTracker(list: List<Feeds.Article>){
        this.collect=list
        notifyDataSetChanged()
    }

}