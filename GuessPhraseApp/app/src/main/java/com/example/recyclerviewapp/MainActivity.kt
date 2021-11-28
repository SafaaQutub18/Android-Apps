package com.example.recyclerviewapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerV: RecyclerView
    lateinit var newGusseNumET: EditText
    lateinit var sendBt: Button

    var gameTextList: ArrayList<GameText> = ArrayList()
    val gameAdapterRV: GameAdapter by lazy { GameAdapter() }

    //game var:
    var chancesNum = 3
    var random = kotlin.random.Random.nextInt(0, 11)


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

    fun checkNumber(userGusse: Int) {
        var finalText: String
        if (chancesNum > 0) {
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
        } else {
            //gameTextList.add(GameText("Game over"))
            gameOverAlert()
        }

    }

    fun gameOverAlert() {
        // first we create a variable to hold an AlertDialog builder
        val dialogBuilder = AlertDialog.Builder(this)
        // then we set up the input
        // val input = EditText(this)
        // here we set the message of our alert dialog
        dialogBuilder.setMessage("Game over")
            // positive button text and action
            .setPositiveButton("play again", DialogInterface.OnClickListener { dialog, id ->

                this.gameTextList.clear()

                //game var:
                this.chancesNum = 3
                this.random = kotlin.random.Random.nextInt(0, 11)
                gameAdapterRV.setGameList(gameTextList)
                newGusseNumET.setText("") // نفضي الedit text

            })
            // negative button text and action
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id ->
                dialog.cancel()
            })
        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle("Game overc")
        // add the Edit Text
        //alert.setView(input)
        // show alert dialog
        alert.show()
    }
}