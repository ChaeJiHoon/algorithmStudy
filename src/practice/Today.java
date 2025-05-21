package practice;

import java.time.LocalDate;

public class Today {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.print(today.getYear()+"-");

        if(today.getMonthValue()<10) System.out.print("0"+today.getMonthValue());
        else System.out.print(today.getMonthValue());

        if(today.getDayOfMonth()<10) System.out.print("-0"+today.getDayOfMonth());
        else System.out.print("-"+today.getDayOfMonth());
    }
}
