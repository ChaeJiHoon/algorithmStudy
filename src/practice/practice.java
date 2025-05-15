package practice;

import java.util.Scanner;

public class practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();

        sc.nextLine();

        String[] A = sc.nextLine().split(" ");

        for(int i=0;i<N;i++){
            if(X > Integer.valueOf(A[i])){
                System.out.print(A[i] + " ");
            }
        }

    }
}
