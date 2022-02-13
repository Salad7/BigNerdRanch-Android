package com.example.retrofitdemo

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(private val itemsIn :ArrayList<ToDoItem>, ctx :Context, r :Int) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    private lateinit var ctx :Context
    private var res = 0
//    private lateinit var  items  :ArrayList<ToDoItem>


//    public constructor(ctx :Context, r :Int, it :ArrayList<ToDoItem>){
//        this.ctx = ctx;
//        res = r
//        items = it;
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        TODO("Not yet implemented")
        val view = LayoutInflater.from(ctx).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        TODO("Not yet implemented")
        holder.checkbox.isChecked = itemsIn.get(position).completed
        holder.text.setText(itemsIn.get(position).title)
    }

    override fun getItemCount(): Int {
        return itemsIn.size
    }

    class TodoViewHolder(v : View) : RecyclerView.ViewHolder(v), View.OnClickListener{
    private var view :View = v;
    public lateinit var text :TextView
    public lateinit var checkbox :CheckBox

    private var todo :ToDoItem? = null


        init {
            v.setOnClickListener(this)
            text = view.findViewById(R.id.tv_title)
            checkbox = view.findViewById(R.id.checkBox)

        }

        override fun onClick(p0: View?) {
            Log.d("RecyclerView","Click!")
        }


    }
}

