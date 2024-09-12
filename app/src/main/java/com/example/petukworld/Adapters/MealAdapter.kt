package com.example.petukworld.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.petukworld.R
import com.example.petukworld.databinding.ItemMealBinding
import com.example.petukworld.domain.model.MealItem

class MealAdapter(
    private val meals: List<MealItem?>
) : RecyclerView.Adapter<MealAdapter.MealViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMealBinding.inflate(inflater, parent, false) // Inflate using DataBinding
        return MealViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
    meals[position].let {
        holder.binding.apply {
            mealName.text = it?.title

        }
        Glide.with(holder.itemView.context)
            .load(it?.thumbImageUrl).into(holder.binding.mealImage)
    }
    }

    override fun getItemCount(): Int {
        return meals.size
    }
    inner class MealViewHolder( val binding: ItemMealBinding) :
        RecyclerView.ViewHolder(binding.root)

}