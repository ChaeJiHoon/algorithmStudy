package practice;

import java.util.Scanner;

public class MachOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int n = sc.nextInt();
        int nextN2 = n/2;


        while(n!=1){


            if(n%2 == 0 && nextN2%2 ==0){
                n = n/2;
            }else if(n%3 == 0){
                n= n/3;
            }else if(n%2 == 0){
                n = n/2;
            }else {
                n--;
            }
            count++;


            nextN2 = n/2;

        }
        System.out.println(count);
    }
}
