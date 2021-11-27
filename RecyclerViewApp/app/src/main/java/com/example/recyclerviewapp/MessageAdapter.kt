package com.example.recyclerviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MessageAdapter :  RecyclerView.Adapter<MessageAdapter.MeessageViewHolder>() {
    var messagesList : ArrayList<Message> = ArrayList()

    fun setMessageList(messageArrayList: ArrayList<Message>) {
        this.messagesList = messageArrayList
        notifyDataSetChanged()
    }

    // I think the viewholder = cell
    class MeessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvMessage : TextView = itemView.findViewById(R.id.tvMessage)

        fun bind(message: Message){
            tvMessage.text = message.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeessageViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.messagesrecycleview, parent, false)
        return MeessageViewHolder(view)
    }
// get text or any thing inside the cell(I think here called view holder)
    //holder : used to access the viwes inside the viewholder (ex: textmimage)
    // position: the current position of current index of particular view
    override fun onBindViewHolder(holder: MeessageViewHolder, position: Int) {
    // itemview: view that contains all of our single view inside messagerecycleview.xml (in my case: it contain just text)
        holder.itemView.apply {
            holder.bind(messagesList[position])
        }
    }

    override fun getItemCount() = messagesList.size
    // or we can write the func with body and return as usual :
    //override fun getItemCount(){return messages.size}

    //}
}