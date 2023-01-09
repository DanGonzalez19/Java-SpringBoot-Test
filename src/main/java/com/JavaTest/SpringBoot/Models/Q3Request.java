package com.JavaTest.SpringBoot.Models;

import lombok.Getter;
import lombok.Setter;

public class Q3Request {
    @Getter @Setter
    String statName;

    public Q3Request(String statName){
        this.statName=statName;
    }
}
