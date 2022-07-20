package com.example.retrofitproject.model

import androidx.lifecycle.MutableLiveData
import com.example.retrofitproject.network.ApiClient
import com.example.retrofitproject.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.lang.StringBuilder

class Repository(private var retrofitservice: ApiInterface) {
    suspend fun getAllProducts() = retrofitservice.fetchAllProducts()
}

