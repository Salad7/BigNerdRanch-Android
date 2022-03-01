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

    public UUID getmId() {
        return mId;
    }

    public void setmId(UUID mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public Date getDate(){
        return mDate;
    }

    public void setDate(Date d){
        mDate = d;
    }

    public void setSolved(boolean solved){
        mSolved = solved;
    }

    public Boolean getSolved(){
        return mSolved;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
