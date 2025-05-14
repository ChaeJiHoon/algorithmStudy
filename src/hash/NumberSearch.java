package hash;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NumberSearch {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();

        int M = sc.nextInt();

        for(int i=0;i<M;i++){
            set.add(sc.nextInt());
        }

        int N = sc.nextInt();

        for(int i=0;i<N;i++){
            int num = sc.nextInt();
            if(set.contains(num)){
                System.out.println(1);
            }else System.out.println(0);
        }
    }
}
