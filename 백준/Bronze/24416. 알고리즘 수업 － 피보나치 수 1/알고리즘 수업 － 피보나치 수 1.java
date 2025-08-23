import java.io.*;

public class Main {
    static int funcIndex = 0;
    static int dpIndex = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        func(n);
        dp(n);
        System.out.println(funcIndex+ " " + dpIndex);
    }

    static int func(int n){

        if(n==1 || n==2) {
            funcIndex++;
            return 1;
        }
        else return(func(n-1) + func(n-2));
    }

    static int dp(int n){
        int dpArr[] = new int[n+1];

        dpArr[1] = 1;
        dpArr[2] = 1;

        for(int i=3;i<=n;i++) {
            dpArr[i] = dpArr[i-1] + dpArr[i-2];
            dpIndex++;
        }

        return dpArr[n];
    }
}
