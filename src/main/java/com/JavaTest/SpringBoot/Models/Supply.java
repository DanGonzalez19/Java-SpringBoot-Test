package com.JavaTest.SpringBoot.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Supply {
    @Getter @Setter
    String productId;
    @Getter @Setter
    Date updateTimeStamp;
    @Getter @Setter
    Double quantity;
    @Getter @Setter
    String status;

    public Supply(String productId, Date updateTimeStamp, Double quantity) {
        this.productId = productId;
        this.updateTimeStamp = updateTimeStamp;
        this.quantity = quantity;
    }
    public Supply(String productId, Date updateTimeStamp, Double quantity, String status) {
        this.productId = productId;
        this.updateTimeStamp = updateTimeStamp;
        this.quantity = quantity;
        this.status = status;
    }
}
