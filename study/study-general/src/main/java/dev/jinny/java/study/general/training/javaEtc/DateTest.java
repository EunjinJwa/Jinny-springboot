package dev.jinny.java.study.general.training.javaEtc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class DateTest {

    public static void main(String[] args) {
        localDateTest1();
    }

    public static void localDateTest1() {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        long timestamp = System.currentTimeMillis();


        DateFormat format = new SimpleDateFormat("yyyyMM");

        String formatString = format.format(timestamp);
        System.out.println(formatString);

        System.out.println(format.format(1633794654487l));



    }
}
