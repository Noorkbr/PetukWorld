package com.example.petukworld.domain.model

import androidx.annotation.Keep

@Keep
data class MealItem(
    val id: String = "",
    val title: String = "",
    val thumbImageUrl: String = ""
)
