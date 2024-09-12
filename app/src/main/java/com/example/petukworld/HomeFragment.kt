package com.example.petukworld


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.petukworld.Adapters.MealAdapter
import com.example.petukworld.core.Resource
import com.example.petukworld.databinding.FragmentHomeBinding
import com.example.petukworld.presentation.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: MealAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        observer()
        return binding.root
    }

    private fun observer() {
        viewModel.getMealData("Dessert")
        viewModel.mealData.observe(viewLifecycleOwner)
        {
            adapter = MealAdapter(it)
            binding.mealsRecyclerView.adapter = adapter

        }
    }


}