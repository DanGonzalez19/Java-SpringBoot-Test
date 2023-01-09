package com.JavaTest.SpringBoot.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Availability {
    @Getter @Setter
    String storeNo;
    @Getter @Setter
    String productId;
    @Getter @Setter
    Date date;
    @Getter @Setter
    Double availQty;



    public Availability(String storeNo, String productId, Date date,Double availQty) {
        this.storeNo = storeNo;
        this.productId = productId;
        this.date=date;
        this.availQty = availQty;

    }
}
