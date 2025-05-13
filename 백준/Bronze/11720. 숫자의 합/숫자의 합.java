import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        String[] strarr = str.split("");
        int[] intarr = new int[n];
        int answer = 0 ;

        for(int i=0;i<n;i++){
            intarr[i] = Integer.valueOf(strarr[i]);
        }

        for (int i : intarr) {
            answer += i;
        }

        System.out.println(answer);
    }
}
