package com.example.umbrella.view

import android.app.Application
import android.content.Context

class CustomApplication : Application(){
    companion object{
        private var myCustomApplication : Context? = null

        fun getApplication(): Context{
            return myCustomApplication!!
        }
    }

    override fun onCreate() {
        super.onCreate()
    }

}