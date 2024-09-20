package com.example.petukworld.domain.repository

import com.example.petukworld.data.dto.ResponseMealDTO
import com.example.petukworld.data.dto.ResponseMealDTODetails
import retrofit2.Response

interface MealRepository {

    suspend fun getMealList(mealName: String): Response<ResponseMealDTO>

    suspend fun getMealDetails(mealId: String): Response<ResponseMealDTODetails>
}