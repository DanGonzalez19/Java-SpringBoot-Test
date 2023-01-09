package com.JavaTest.SpringBoot.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Q3Response {
    @Getter @Setter
    String productId;
    @Getter @Setter
    List<Order> orderList;

    public Q3Response(String productId, List<Order> orderList) {
        this.productId = productId;
        this.orderList = orderList;
    }
}
