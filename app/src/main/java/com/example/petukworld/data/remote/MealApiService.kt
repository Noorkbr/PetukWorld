package com.example.petukworld.data.remote

import com.example.petukworld.data.dto.ResponseMealDTO
import com.example.petukworld.data.dto.ResponseMealDTODetails
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query

interface MealApiService {
    @GET("json/v1/1/filter.php")
    suspend fun getMealList(
        @Query("c") mealName: String
    ): retrofit2.Response<ResponseMealDTO>


    @GET("lookup.php")
    suspend fun getMealDetails(
        @Query("i") mealId: String
    ): Response<ResponseMealDTODetails>


}