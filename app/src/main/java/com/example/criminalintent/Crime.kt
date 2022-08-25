package com.example.criminalintent

import java.util.*

class Crime(mId : UUID, mTitle :String, dat :Date, iss :Boolean) {
    var id = mId;
    var title = mTitle
    var date = dat;
    var isSolveddd = iss;

    fun getTTitle() : String{
        return title
    }
    fun getID() : UUID {
        return id
    }

    fun getTDate() : Date {
        return date
    }

    fun setTDate(d :Date){
        date = d
    }

    fun setSolved(i :Boolean){
        isSolveddd = i
    }

    fun isSolvedd() : Boolean {
        return isSolveddd
    }
    fun setTTitle(mTitle: String){
        title = mTitle
    }

    fun setID(uuid :UUID){
        id = uuid
    }
}