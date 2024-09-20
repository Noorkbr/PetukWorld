package com.example.petukworld.Adapters

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.petukworld.R

fun urlToImage(view: ImageView,imageUrl:String){
    val options = RequestOptions.placeholderOf(R.drawable.placeholder).error(R.drawable.placeholder)
    Glide.with(view).setDefaultRequestOptions(options).load(imageUrl).into(view)




}