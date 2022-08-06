package com.example.mudae.Objects;

public class Mudae {

    public String name;
    public String imgUrl;
    public int rank;
    public Long claimDate;

    public Mudae(){
        name = "";
        imgUrl = "";
        rank = 0;
        claimDate = 0L;
    }

    public Mudae(String name, String imgUrl, int rank, Long claimDate) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.rank = rank;
        this.claimDate = claimDate;
    }
}
