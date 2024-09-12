package com.example.petukworld.data.remote

import com.example.petukworld.data.dto.ResponseMealDTO

import retrofit2.http.GET
import retrofit2.http.Query

interface MealApiService {
    @GET("json/v1/1/filter.php")
    suspend fun getMealList(
        @Query("c") mealName: String
    ): retrofit2.Response<ResponseMealDTO>
}