package com.JavaTest.SpringBoot.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Q2Response {

    @Getter @Setter
    String storeNo;
    @Getter @Setter
    String productId;
    @Getter @Setter
    Double reqQty;
    @Getter @Setter
    Date reqDate;
    @Getter @Setter
    String status;

    public Q2Response(String storeNo, String productId, Double reqQty, Date reqDate) {
        this.storeNo = storeNo;
        this.productId = productId;
        this.reqQty = reqQty;
        this.reqDate = reqDate;
    }
}
