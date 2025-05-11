package bruteForce;

import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int answer =0;

        int[] arr = new int[N];

        for(int i =0; i<N;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(blackJack(N, M, arr, answer));

    }

    private static int blackJack(int N, int M, int[] arr, int answer){
        for(int i =0; i<N-2;i++){
            for(int j=i+1;j<N-1;j++){
                for(int k=j+1;k<N;k++){
                    int sum = arr[i]+arr[j]+arr[k];

                    if(sum<=M && sum>answer){
                        answer = sum;
                    }

                    if(sum == M) return answer;
                }
            }
        }
        return answer;
    }
}
