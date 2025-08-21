import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split("");

        int answer = 0;

        for(int i=0;i<str.length;i++){
            String s = str[i];

            if(s.equals("A")||s.equals("B")||s.equals("C")) answer += 3;
            else if(s.equals("D")||s.equals("E")||s.equals("F")) answer += 4;
            else if(s.equals("G")||s.equals("H")||s.equals("I")) answer += 5;
            else if(s.equals("J")||s.equals("K")||s.equals("L")) answer += 6;
            else if(s.equals("M")||s.equals("N")||s.equals("O")) answer += 7;
            else if(s.equals("P")||s.equals("Q")||s.equals("R")||s.equals("S")) answer += 8;
            else if(s.equals("T")||s.equals("U")||s.equals("V")) answer += 9;
            else if(s.equals("W")||s.equals("X")||s.equals("Y")||s.equals("Z")) answer += 10;
        }

        System.out.println(answer);

    }
}
