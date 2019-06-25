package org.mp.recipes.data.di.feature.home

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.news_list_items.view.*
import org.mp.recipes.data.remote.model.Fields
import org.mp.recipes.data.remote.model.ItemsItem
import java.util.regex.Pattern


class NewsAdapter(val dataSource: List<ItemsItem>, private val share:(Fields?)->Unit) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(org.mp.recipes.R.layout.news_list_items, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
           with(dataSource[position].fields)
           {
               holder.headline?.text = name
               if(body!=null) {
                   val mydata =  body
                   val regex = "src\\s*=\\s*\"(.+?)\""

                   val pattern = Pattern.compile(regex)
                   val matcher = pattern.matcher(mydata)
                   val imgUrls = ArrayList<String>()
                   while (matcher.find()) {
                       imgUrls.add(matcher.group(1))
                   }
                   Glide.with(holder.coverImage.context).load("https:"+imgUrls[0]).into(holder.coverImage)
               }
               holder.item.setOnClickListener { share.invoke(this) }
           }
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }


}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val item = view
    val headline = view.headlineTv
    val coverImage = view.coverImage
}