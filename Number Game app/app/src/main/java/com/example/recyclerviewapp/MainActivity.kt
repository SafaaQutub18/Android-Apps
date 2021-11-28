package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerV : RecyclerView
    lateinit var newGusseNumET: EditText
    lateinit var sendBt : Button

    var gameTextList:ArrayList<GameText> = ArrayList()
    val gameAdapterRV : GameAdapter by lazy { GameAdapter() }

    //game var:
    var chancesNum = 3
    val random = kotlin.random.Random.nextInt(0,11)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerV = findViewById(R.id.rvGameText)
        newGusseNumET = findViewById(R.id.editTextNewNumber)
        sendBt = findViewById(R.id.sendBt)

        recyclerV.adapter = gameAdapterRV



        sendBt.setOnClickListener {
            val userNum = Integer.parseInt(newGusseNumET.text.toString())
            checkNumber(userNum)
            gameAdapterRV.setGameList(gameTextList)
            newGusseNumET.setText("") // نفضي الedit text

            //gameTextList.add(GameText())

        }
    }

    fun checkNumber(userGusse: Int){
        var finalText : String
        if (chancesNum > 0){
            gameTextList.add(GameText("you guessed $userGusse"))
            when (userGusse) {
                random -> {
                    println("you got it *_*")
                    gameTextList.add(GameText("you got it *_* , correct answer"))
                    chancesNum = 0
                }
                else -> {
                    println("wrong guess")
                    chancesNum--
                    gameTextList.add(GameText("wrong guess, you have $chancesNum guesses left"))
                }
            }
        }
        else{
            gameTextList.add(GameText("Game over"))
        }

    }
}