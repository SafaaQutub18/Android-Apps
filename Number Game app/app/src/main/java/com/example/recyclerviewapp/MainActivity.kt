package com.example.recyclerviewapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var phraseText: TextView
    lateinit var recyclerV: RecyclerView
    lateinit var newGusseNumET: EditText
    lateinit var sendBt: Button

    var guessesTextList: ArrayList<GuessesText> = ArrayList()
    val phraseAdapterRV: PhraseAdapter by lazy { PhraseAdapter() }

    //Phrase var:
    var myPhrase = "this is the secret phrase"
    var starsString = "**** ** *** ****** ******"
    var unguessedletter = 9
    var lossCount = 0
    var guessedLetter = ""
    var resultText = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerV = findViewById(R.id.rvGameText)
        newGusseNumET = findViewById(R.id.editTextNewNumber)
        sendBt = findViewById(R.id.sendBt)
        phraseText = findViewById(R.id.phraseTV)


        recyclerV.adapter = phraseAdapterRV

        phraseText.text = "Phrase: $starsString\nGuessed letters:"

        sendBt.setOnClickListener {
            val userGuess = newGusseNumET.text.toString()
            if(lossCount < 10)
                checkGuess(userGuess)
            else{
                resultText = "You loss T.T"
                gameOverAlert()
            }

            phraseText.text = "Phrase: $starsString\nGuessed letters: $guessedLetter "
            phraseAdapterRV.setPhraseList(guessesTextList)
            newGusseNumET.setText("") // نفضي الedit text

        }
    }

    fun checkGuess(userGusse: String) {
        if (userGusse.length > 1) {
            when (userGusse) {
                myPhrase -> {
                    resultText = "You win!"
                    gameOverAlert()
                }
                else -> {
                    lossCount++
                    guessesTextList.add(GuessesText("wrong guess: $userGusse ","#FA2500"))
                }
            }
        } else {
            if(myPhrase.contains(userGusse))
                checkLetter(userGusse)
            else {
                lossCount++
                guessesTextList.add(GuessesText("wrong guess: $userGusse","#FA2500"))
            }
        }


    }
    fun checkLetter(letter: String) {
        var foundCount = 0
        // check if the guess completed
        if (starsString.contains('*')) {
            //check if the letter entered previously
            if(!guessedLetter.contains(letter)) {
                guessedLetter += (letter + ",")
                unguessedletter--
            }
            var index = myPhrase.indexOf(letter)
            while (index >= 0) {
                foundCount++
                starsString[index] = letter
                val chars = starsString.toCharArray()
                chars[index] = letter.single()
                starsString = String(chars)
                index = myPhrase.indexOf(letter, index + 1);
            }
            guessesTextList.add(GuessesText("found $foundCount $letter(s)","#33D402"))
            guessesTextList.add(GuessesText("$unguessedletter guess remaining","#010300"))
        } else {
            resultText = "You win!"
            gameOverAlert()
        }
    }

    fun gameOverAlert() {
        // first we create a variable to hold an AlertDialog builder
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setMessage("$resultText \n Play again?")
            // positive button text and action
            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, id -> this.recreate() })
            // negative button text and action
            .setNegativeButton("No", DialogInterface.OnClickListener { dialog, id -> dialog.cancel()})
        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle("Game over")
        // add the Edit Text
        //alert.setView(input)
        // show alert dialog
        alert.show()
    }
}

private operator fun String.set(i: Int, value: String) {

}
