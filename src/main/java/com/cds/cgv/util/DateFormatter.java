package com.cds.cgv.util;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    public static String format(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
