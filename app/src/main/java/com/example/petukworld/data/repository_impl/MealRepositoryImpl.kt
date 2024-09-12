package com.example.petukworld.data.repository_impl

import com.example.petukworld.data.dto.ResponseMealDTO
import com.example.petukworld.data.remote.MealApiService
import com.example.petukworld.domain.repository.MealRepository
import retrofit2.Response
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val apiService: MealApiService
) : MealRepository {
    override suspend fun getMealList(mealName: String): Response<ResponseMealDTO> {
        val response = apiService.getMealList(mealName)
        return response

    }
}