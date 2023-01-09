package com.JavaTest.SpringBoot.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Capacity {
    @Getter @Setter
    String storeNo;

    @Getter @Setter
    String prodId;
    @Getter @Setter
    Date date;
    @Getter @Setter
    double noOfOrdersAccepted;


    public Capacity(String storeNo, String prodId,Date date, double noOfOrdersAccepted) {
        this.storeNo = storeNo;
        this.prodId = prodId;
        this.date = date;
        this.noOfOrdersAccepted = noOfOrdersAccepted;
    }
}
