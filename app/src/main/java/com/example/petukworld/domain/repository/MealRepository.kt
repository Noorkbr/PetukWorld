package com.example.petukworld.domain.repository

import com.example.petukworld.data.dto.ResponseMealDTO
import retrofit2.Response

interface MealRepository {

    suspend fun getMealList(mealName: String): Response<ResponseMealDTO>

}