package com.example.a4_retrofitviewmodelscopervglide.repository

import com.example.a4_retrofitviewmodelscopervglide.api.MyApi
import com.example.a4_retrofitviewmodelscopervglide.api.RetrofitInstance

class Repository {

    private val client = RetrofitInstance.getInstance().create(MyApi::class.java)

    suspend fun getAllData() = client.getAllPlants()
}