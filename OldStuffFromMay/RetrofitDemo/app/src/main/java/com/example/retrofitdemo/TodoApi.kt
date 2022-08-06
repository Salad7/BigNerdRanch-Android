package com.example.retrofitdemo

import org.json.JSONArray
import retrofit2.Response
import retrofit2.http.GET
import java.util.*

interface TodoApi {
    @GET("/todos")
    suspend fun getTodos() : Response<ArrayList<ToDoItem>>
}