import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[20000];

        for(int i=1;i<=10000;i++){
            int num=0;
            String[] str = Integer.toString(i).split("");
            num += i;
            for(int j=0;j<str.length;j++) num += Integer.parseInt(str[j]);
            arr[num]++;
        }

        for(int i=1;i<=10000;i++) if(arr[i]==0) sb.append(i).append("\n");

        System.out.println(sb.toString());
    }
}
