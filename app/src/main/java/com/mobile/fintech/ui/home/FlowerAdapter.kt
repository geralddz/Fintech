package com.mobile.fintech.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobile.fintech.R
import com.mobile.fintech.data.local.database.model.Flower
import kotlin.math.log

class FlowerAdapter: RecyclerView.Adapter<FlowerAdapter.ViewHolder>() {
    private val flowers = mutableListOf<Flower>()
    private var _itemClick: FlowerAdapter.ItemClick<Flower>? = null

    fun setOnItemClickListener(itemClick: ItemClick<Flower>) {
        _itemClick = itemClick
    }

    fun submitList(newFlowers: List<Flower>){
        flowers.clear()
        flowers.addAll(newFlowers)
        notifyDataSetChanged()
    }

    interface ItemClick<T> {
        fun onItemClick(view: View, data: T, position: Int)
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        val tvFlowerName = view.findViewById<TextView>(R.id.tv_flower_name)
        val imgFlower = view.findViewById<ImageView>(R.id.img_flower)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater
           .from(parent.context)
           .inflate(R.layout.item_flower,parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val flower =flowers[position]
        holder.apply {
            tvFlowerName.text = flower.flowerName

            Log.d("test", "onBindViewHolder: " + flower.flowerImageUrl)
            Glide.with(holder.itemView)
                .load(flower.flowerImageUrl)
                .centerCrop()
                .into(imgFlower)

            _itemClick?.let { itemClick->
                itemView.setOnClickListener {
                    itemClick.onItemClick(it, flower, position)
                }
            }
        }
    }

    override fun getItemCount() = flowers.size


}