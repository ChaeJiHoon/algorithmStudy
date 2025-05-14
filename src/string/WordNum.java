package string;

import java.util.Scanner;

public class WordNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().trim();

        String[] arr = str.split(" ");

        System.out.println(arr.length);
    }
}
