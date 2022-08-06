package com.example.retrofitdemo

class ToDoItem {
    public lateinit var userId :String
    public var id = 0
    public lateinit var title :String
    public var completed = false

    public constructor(u :String, i :Int, tit :String, com :Boolean){
        userId = u;
        id = i;
        title = tit
        completed = com
    }



}