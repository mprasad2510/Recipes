package org.mp.recipes.data.di.feature.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import kotlinx.android.synthetic.main.news_list_items.view.*
import org.mp.recipes.R
import org.mp.recipes.data.remote.model.Fields
import org.mp.recipes.data.remote.model.Items


class NewsAdapter(val dataSource: List<Items>, private val share:(Fields?)->Unit) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.news_list_items, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
           with(dataSource[position])
           {
               holder.headline?.text = fields?.title
               holder.item.setOnClickListener { share.invoke(this.fields) }

           }
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }


}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val item = view
    val headline = view.headlineTv
}