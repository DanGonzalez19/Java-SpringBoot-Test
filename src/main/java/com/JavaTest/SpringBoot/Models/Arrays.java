package com.JavaTest.SpringBoot.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

public class Arrays {

    @Getter @Setter
    ArrayList<Supply> supplies = new ArrayList<>();

    @Getter @Setter
    ArrayList<Availability> availabilities = new ArrayList<>();

    @Getter @Setter
    ArrayList<Capacity> capacities = new ArrayList<>();

    @Getter @Setter
    ArrayList<Order> orders = new ArrayList<>();


    public Arrays(){
        supplies.add(new Supply("Product1",DateConvert.StringToDate("yyyy-MM-dd'T'HH:mm:ss.SSS","2021-03-16T08:53:48.616Z"),10.0));
        supplies.add(new Supply ("Product2",DateConvert.StringToDate("yyyy-MM-dd'T'HH:mm:ss.SSS","2021-03-16T08:59:48.616Z"),5.0));
        supplies.add(new Supply ("Product3",DateConvert.StringToDate("yyyy-MM-dd'T'HH:mm:ss.SSS","2021-03-16T09:10:48.616Z"),30.0));
        supplies.add(new Supply ("Product4",DateConvert.StringToDate("yyyy-MM-dd'T'HH:mm:ss.SSS","2021-03-16T09:10:48.616Z"),20.0));

        availabilities.add(new Availability ("Store001", "Prod1", DateConvert.StringToDate("yyyy-MM-dd","2021-02-19"), 1.0));
        availabilities.add(new Availability  ("Store001", "Prod2", DateConvert.StringToDate("yyyy-MM-dd","2021-02-20"), 3.0));
        availabilities.add(new Availability  ("Store001", "Prod2",DateConvert.StringToDate("yyyy-MM-dd","2021-02-21"), 0.0));

        capacities.add( new Capacity(" Store001", "Prod1", new Date(2021 - 02 - 19), 0));
        capacities.add( new Capacity( " Store001", "Prod1", new Date(2021 - 02 - 20), 2.0));
        capacities.add( new Capacity(" Store001", "Prod1", new Date(2021 - 02 - 21), 2.0));
        capacities.add( new Capacity( " Store001", "Prod1", new Date(2021 - 02 - 22), 0));

       orders.add( new Order("Order1","Product1",new Date("2021-03-16"),10.0));
       orders.add( new Order("Order2", "Product2",new Date("2021-03-19"),5.0));
       orders.add( new Order("Order3", "Product1",new Date("2021-03-16"),30.0));
       orders.add( new Order("Order4", "Product4",new Date("2021-03-20"),20.0));
       orders.add( new Order("Order5", "Product2",new Date("2021-03-16"),20.0));


    }

}
