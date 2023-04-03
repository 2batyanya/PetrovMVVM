package com.example.petrovmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val liveDataString = MutableLiveData<String>()
    val liveDataString2 = MutableLiveData<String>()
    val mediatorLiveData = MediatorLiveData<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var editText = findViewById<EditText>(R.id.edit_text)
        var buttonSave = findViewById<Button>(R.id.button_save)
        var buttonSave2 = findViewById<Button>(R.id.button_save2)
        var textView1 = findViewById<TextView>(R.id.test_text1)
        var textView2 = findViewById<TextView>(R.id.test_text)

        liveDataString.value = "string"
        liveDataString2.value = "string2"

        mediatorLiveData.addSource(liveDataString) {
            textView1.text = it
        }

        mediatorLiveData.addSource(liveDataString2){
            textView2.text = it
        }

        mediatorLiveData.observe(this, Observer{

        })

        buttonSave.setOnClickListener {
            liveDataString.value = editText.text.toString()
        }

        buttonSave2.setOnClickListener {
            liveDataString2.value = editText.text.toString()
        }
    }
}