package com.example.retrofitproject.network

import com.example.retrofitproject.model.Product
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// This is the network interface that is the function we are interested in calling
// This will be useful in calling the retrofit object
interface ApiInterface {
    @GET("comments")
    suspend fun fetchAllProducts(): Response<List<Product>>
    companion object{
        var retrofitService: ApiInterface? = null
        fun getInstance() : ApiInterface {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(ApiInterface::class.java)
            }
            return retrofitService!!
        }

    }
}