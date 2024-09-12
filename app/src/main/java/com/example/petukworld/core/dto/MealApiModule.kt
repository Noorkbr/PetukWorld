package com.example.petukworld.core.dto

import com.example.petukworld.data.remote.MealApiService
import com.example.petukworld.data.repository_impl.MealRepositoryImpl
import com.example.petukworld.domain.repository.MealRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MealApiModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideMealApiService(
        retrofit: Retrofit
    ): MealApiService {
        return retrofit.create(MealApiService::class.java)

    }

    @Provides
    @Singleton
    fun provideRepo(
        apiService: MealApiService
    ): MealRepository {
        return MealRepositoryImpl(apiService)

    }


}