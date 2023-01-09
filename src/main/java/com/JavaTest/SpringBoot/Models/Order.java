package com.JavaTest.SpringBoot.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Order {

    @Getter @Setter
    String orderId;
    @Getter @Setter
    String productId;
    @Getter @Setter
    Date createDate;
    @Getter @Setter
    Double quantity;

    public Order(String orderId,String productId, Date createDate, Double quantity) {
        this.orderId=orderId;
        this.productId = productId;
        this.createDate = createDate;
        this.quantity = quantity;
    }
}
