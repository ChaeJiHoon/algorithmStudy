package practice;

import java.util.*;
import java.io.*;

public class Pr3{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        if(str1.length()<str2.length()) System.out.println("no");
        else System.out.println("go");

    }
}