package com.example.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime(){
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public Date getDate(){
        return mDate;
    }

    public void setSolved(boolean s){
        mSolved = s;
    }

    public boolean isSolved(){
        return mSolved;
    }

    public UUID getId(){
        return mId;
    }

    public String getTitle(){
        return mTitle;
    }

    public void setTitle(String title){
        mTitle = title;
    }
}
