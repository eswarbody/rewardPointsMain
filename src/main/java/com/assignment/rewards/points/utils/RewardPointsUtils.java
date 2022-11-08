package com.assignment.rewards.points.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class RewardPointsUtils {


    public static final String CUSTOMER_NOT_EXISTS = "CUSTOMER NOT EXISTS";
    public static final String NO_RECORD_FOUND = "No Record Found";

    public  LocalDate convertStToDate(String date){
        return LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
