import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a=0,b=0,c=0;
        while(true){
            if(n/300>0){
                a = n/300;
                n = n%300;
            }else if(n/60>0){
                b = n/60;
                n = n%60;
            }else if(n/10>0){
                c = n/10;
                n = n%10;
            }else if(n==0){
                System.out.print(a+" "+b+" "+c);
                return;
            }else{
                System.out.print(-1);
                return;
            }

        }
    }
}