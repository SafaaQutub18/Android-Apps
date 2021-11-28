package com.example.recyclerviewapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PhraseAdapter :  RecyclerView.Adapter<PhraseAdapter.PhraseViewHolder>() {
    var textGuessesList : ArrayList<GuessesText> = ArrayList()

    fun setPhraseList(guessesTextArrayList: ArrayList<GuessesText>) {
        this.textGuessesList = guessesTextArrayList
        notifyDataSetChanged()
    }

    // I think the viewholder = cell
    class PhraseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvPhrase : TextView = itemView.findViewById(R.id.tvtvPhraseText)

        fun bind(guessesText: GuessesText){
            tvPhrase.text = guessesText.text
            tvPhrase.setTextColor(Color.parseColor(guessesText.color))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhraseViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.phrasesrecycleview, parent, false)
        return PhraseViewHolder(view)
    }
// get text or any thing inside the cell(I think here called view holder)
    //holder : used to access the viwes inside the viewholder (ex: textmimage)
    // position: the current position of current index of particular view
    override fun onBindViewHolder(holder: PhraseViewHolder, position: Int) {
    // itemview: view that contains all of our single view inside gamerecycleview.xml (in my case: it contain just text)
        holder.itemView.apply {
            holder.bind(textGuessesList[position])
        }
    }

    override fun getItemCount() = textGuessesList.size
    // or we can write the func with body and return as usual :
    //override fun getItemCount(){return game.size}

    //}
}