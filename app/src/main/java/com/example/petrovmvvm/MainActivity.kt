package com.example.petrovmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val myLiveData = MyLiveData()
    lateinit var observer: Observer<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var editText = findViewById<EditText>(R.id.edit_text)
        var buttonSave = findViewById<Button>(R.id.button_save)
        var textView1 = findViewById<TextView>(R.id.test_text1)

        observer = Observer{
            textView1.text = it
        }

        buttonSave.setOnClickListener {
            myLiveData.setValueToLiveData(editText.text.toString())
        }
    }

    override fun onStart() {
        super.onStart()
        myLiveData.observe(this, observer)
    }

    override fun onStop() {
        super.onStop()
        myLiveData.removeObserver(observer)
    }

}