package com.example.petukworld.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petukworld.core.Resource
import com.example.petukworld.domain.model.MealItem
import com.example.petukworld.domain.usecase.GetMealListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: GetMealListUseCase
) : ViewModel() {

    // Exposing meal data as LiveData to be observed by the Fragment
    private val _mealData = MutableLiveData<List<MealItem?>>()
    val mealData: LiveData<List<MealItem?>> get() = _mealData


    fun getMealData(mealName: String) {

        viewModelScope.launch {


            useCase.invoke(mealName).collect { response ->

                when (response) {
                    is Resource.Error -> {}
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                     response.data.let {
                         Log.d("TAG", "getMealData: ${_mealData.value}")
                         _mealData.value = it
                     }


                    }
                }
            }
        }
    }
}