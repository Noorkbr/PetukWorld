package com.example.petukworld.domain.usecase

import android.util.Log
import com.example.petukworld.core.Resource

import com.example.petukworld.data.dto.toMealItem
import com.example.petukworld.domain.model.MealItem
import com.example.petukworld.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMealListUseCase @Inject constructor(private val repository: MealRepository) {


    operator fun invoke(mealName: String): Flow<Resource<List<MealItem?>?>> = flow {

        try {
            emit(Resource.Loading())
            val data = repository.getMealList(mealName)

            if (data.isSuccessful && data.body() != null) {
                val ml = data.body()!!.meals
                val mlItem = ml?.map { it?.toMealItem() }

                emit(Resource.Success(mlItem))
            }


        } catch (e: Exception) {
            Log.d("Exception", "invoke: ${e.message}")
            emit(Resource.Error(e.message ?: "Some Error"))
        }


    }


}