package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class practice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String str = br.readLine();
            sb.append(i+1).append("번째 받은 문자 내용 : ").append(str).append("\n");
        }
        System.out.println(sb);
    }
}
