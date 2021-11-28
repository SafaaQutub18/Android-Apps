package com.example.recyclerviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class GameAdapter :  RecyclerView.Adapter<GameAdapter.GameViewHolder>() {
    var textGameList : ArrayList<GameText> = ArrayList()

    fun setGameList(gameTextArrayList: ArrayList<GameText>) {
        this.textGameList = gameTextArrayList
        notifyDataSetChanged()
    }

    // I think the viewholder = cell
    class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvGame : TextView = itemView.findViewById(R.id.tvGameText)

        fun bind(gameText: GameText){
            tvGame.text = gameText.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.numbersrecycleview, parent, false)
        return GameViewHolder(view)
    }
// get text or any thing inside the cell(I think here called view holder)
    //holder : used to access the viwes inside the viewholder (ex: textmimage)
    // position: the current position of current index of particular view
    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
    // itemview: view that contains all of our single view inside gamerecycleview.xml (in my case: it contain just text)
        holder.itemView.apply {
            holder.bind(textGameList[position])
        }
    }

    override fun getItemCount() = textGameList.size
    // or we can write the func with body and return as usual :
    //override fun getItemCount(){return game.size}

    //}
}