package com.example.petrovmvvm

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class GetData: LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun getData(){
        println("getData")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun sendData(){
        println("sendData")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun any(){
        println("any")
    }
}