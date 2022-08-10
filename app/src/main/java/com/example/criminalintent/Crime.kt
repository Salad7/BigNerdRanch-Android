package com.example.criminalintent

import java.util.*

class Crime(mId : UUID, mTitle :String) {
    var id = mId;
    var title = mTitle

    fun getTTitle() : String{
        return title
    }
    fun getID() : UUID {
        return id
    }

    fun setTTitle(mTitle: String){
        title = mTitle
    }

    fun setID(uuid :UUID){
        id = uuid
    }
}