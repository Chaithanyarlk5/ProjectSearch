package com.example.retrofitproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitproject.model.Product
import com.example.retrofitproject.model.Repository
import com.example.retrofitproject.network.ApiInterface
import kotlinx.coroutines.*

class HomeViewModel : ViewModel() {
    val retro = ApiInterface.getInstance()
    val repository = Repository(retro)
    val product_list = MutableLiveData<List<Product>>()
    val errorMessage = MutableLiveData<String>()
    var job:Job?=null
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("ABC")
    }
    private fun onError(message: String) {
        errorMessage.postValue("ABC")
    }
    fun getAllProducts(){
        println("Called getAllProducts")
        job = CoroutineScope(Dispatchers.IO+exceptionHandler).launch {
            val response  = repository.getAllProducts()
            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    product_list.postValue(response.body())
                    //println(response.body())
                }
                else{
                    println("Error!")
                    onError(response.message())
                }
            }
        }
    }

}