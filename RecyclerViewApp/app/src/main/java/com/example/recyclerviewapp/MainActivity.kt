package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerV : RecyclerView
    lateinit var newMessageET: EditText
    lateinit var sendBt : Button

    var messageList:ArrayList<Message> = ArrayList()
    val messageAdapterRV : MessageAdapter by lazy { MessageAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerV = findViewById(R.id.rvMessage)
        newMessageET = findViewById(R.id.editTextNewMessage)
        sendBt = findViewById(R.id.sendBt)

        recyclerV.adapter = messageAdapterRV

        sendBt.setOnClickListener {
            messageList.add(Message(newMessageET.text.toString()))
            messageAdapterRV.setMessageList(messageList)
            newMessageET.setText("") // نفضي الedit text
        }
    }
}