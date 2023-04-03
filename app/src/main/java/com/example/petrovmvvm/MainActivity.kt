package com.example.petrovmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    var ldString = MutableLiveData<String>()
    var ldInt = MutableLiveData<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var editText = findViewById<EditText>(R.id.edit_text)
        var buttonSave = findViewById<Button>(R.id.button_save)
        var textView1 = findViewById<TextView>(R.id.test_text1)
        var textView2 = findViewById<TextView>(R.id.test_text)

        ldString.value = "ldString"
        ldInt.value = 1

        textView2.text = ldString.value + " string"
        textView1.text = ldInt.value.toString() + " Int"


        buttonSave.setOnClickListener {
            ldInt = Transformations.map(ldString){
                it.toInt()
            } as MutableLiveData<Int>

            ldString.observe(this, Observer {
                textView2.text = it
            })
        }
    }
}