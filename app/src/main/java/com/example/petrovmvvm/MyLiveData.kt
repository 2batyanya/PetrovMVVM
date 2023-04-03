package com.example.petrovmvvm

import androidx.lifecycle.LiveData

class MyLiveData: LiveData<String>() {

    fun setValueToLiveData(string: String){
        value = string
    }

    override fun onActive() {
        // super.onActive()
        println("onActive")
        //Connect to DB
    }

    override fun onInactive() {
        super.onInactive()
        println("onInactive")

        //Disconnect
    }
}