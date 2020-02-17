package com.example.umbrella.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.umbrella.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrentViewModel: ViewModel() {

    val data = MutableLiveData<CurrentWeather>()

    fun getCurrentWeather(): LiveData<CurrentWeather> {
        return data
    }

    fun getCurrentWeather(zipCode: String, units: String) {
        val network = Network("https://api.openweathermap.org/data/2.5/")
        network.initRetrofit().getCurrentWeather(zipCode, units)
            .enqueue(object : Callback<CurrentWeather> {
                override fun onFailure(call: Call<CurrentWeather>, t: Throwable) {
                    Log.d("FAILURE", t.toString())
                }
                override fun onResponse(
                    call: Call<CurrentWeather>,
                    response: Response<CurrentWeather>
                ) {
                    data.value = response.body()!!
                }
            })
    }
}