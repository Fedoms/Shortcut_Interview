package org.meeters.xkcd.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_button.view.*
import kotlinx.android.synthetic.main.item_image.view.*
import kotlinx.android.synthetic.main.item_text.view.*
import org.koin.core.component.KoinComponent
import org.meeters.xkcd.R
import org.meeters.xkcd.ext.openUrl
import org.meeters.xkcd.model.RecylcerModel
import org.meeters.xkcd.model.VIEW

class XkcdAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val info: MutableList<RecylcerModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            1 -> {
                val view = LayoutInflater.from(context).inflate(R.layout.item_text, parent, false)
                return XkcdTextViewHolder(view)
            }
            2 -> {
                val view = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false)
                return XkcdImageViewHolder(view)
            }
            3 -> {
                val view = LayoutInflater.from(context).inflate(R.layout.item_button, parent, false)
                return XkcdWebsiteViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(context).inflate(R.layout.item_text, parent, false)
                return XkcdTextViewHolder(view)
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (info[position].view) {
            VIEW.TEXT -> holder.itemView.info_text.text = info[position].value

            VIEW.IMAGE -> {
                Glide.with(context).load(info[position].value).into(holder.itemView.imageComicDetail)
            }
            VIEW.WEBSITE -> holder.itemView.explanation.setOnClickListener {
                context.openUrl(info[position].value)
            }
        }

    }

    override fun getItemCount() = info.size

    override fun getItemViewType(position: Int): Int {
        return when (info[position].view) {
            VIEW.TEXT -> 1
            VIEW.WEBSITE -> 3
            VIEW.IMAGE -> 2
        }
    }

    fun setInfo(list: List<RecylcerModel>) = this.info.apply {
        clear()
        addAll(list)
        notifyDataSetChanged()
    }
}


class XkcdTextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
}
class XkcdImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
}
class XkcdWebsiteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
}