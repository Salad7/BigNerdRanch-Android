package com.example.criminalintent

class Question(mTextResId: Int, mAnswerTrue: Boolean) {

    var textRes = mTextResId
    var isTrue = mAnswerTrue


    public fun getTextResId() : Int{
        return textRes
    }

    public fun getAnswerTrue() : Boolean {
        return isTrue
    }

    public fun setTextResId(mres :Int){
        textRes = mres
    }

    public fun setAnswerTrue(answerTrue :Boolean){
        isTrue = answerTrue
    }
}