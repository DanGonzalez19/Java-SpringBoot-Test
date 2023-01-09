package com.JavaTest.SpringBoot.Models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert {

    public static Date StringToDate(String dateFormat,String dateString){
        try {
            return new SimpleDateFormat(dateFormat).parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
