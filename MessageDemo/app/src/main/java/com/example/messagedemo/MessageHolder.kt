package com.example.messagedemo

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MessageHolder(itemView :View) : RecyclerView.ViewHolder(itemView){
    val messageTV :TextView =  itemView.findViewById(R.id.msg_tv);
}