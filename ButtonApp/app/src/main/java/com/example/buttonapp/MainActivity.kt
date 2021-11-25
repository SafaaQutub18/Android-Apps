package com.example.buttonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var numText : TextView
    lateinit var minusBt : Button
    lateinit var plusBt : Button
    var currentNum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numText = findViewById(R.id.numberText)
        minusBt = findViewById(R.id.minusButton)
        plusBt = findViewById(R.id.plusButton)


        minusBt.setOnClickListener{
            update("-")
        }

        plusBt.setOnClickListener{
            update("+")
        }
    }

    fun update(operator : String){
        if(operator == "+")
            currentNum++
        else
            currentNum--

        numText.text = currentNum.toString()
    }
}