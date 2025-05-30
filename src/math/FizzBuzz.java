package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 |  | 브론즈 1
// 10814 번 : FizzBuzz
// 시간 제한 : 0.5초, 메모리 제한 : 1024 MB
// 25.05.28
public class FizzBuzz {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = 0;
        int num = 0;

        for(int i=1;i<=3;i++){
            String str = br.readLine();
            if(str.charAt(0)=='F' || str.charAt(0)=='B') continue;
            else {
                num = Integer.parseInt(str);
                index = i;
            }
        }

        for(int i=index;i<4;i++){
            num++;
        }

        if(num%3==0 && num%5==0) System.out.println("FizzBuzz");
        else if(num%5==0) System.out.println("Buzz");
        else if(num%3==0) System.out.println("Fizz");
        else System.out.println(num);

    }
}
