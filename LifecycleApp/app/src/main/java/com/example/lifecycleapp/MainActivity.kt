package com.example.lifecycleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "pause")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "resume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "Stop")
    }
    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "Start")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "Restart")
    }
}