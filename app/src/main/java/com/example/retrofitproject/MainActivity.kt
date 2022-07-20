package com.example.retrofitproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitproject.model.Repository
import com.example.retrofitproject.network.ApiInterface
import com.example.retrofitproject.viewmodel.HomeViewModel

class MainActivity : AppCompatActivity() {
    lateinit var mainview_model: HomeViewModel
    var retro = ApiInterface.getInstance()
    var repository = Repository(retro)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainview_model = ViewModelProvider(this).get(HomeViewModel::class.java)

        mainview_model.getAllProducts()

        println("Data is called")

        println("Data call is done!")

    }
}