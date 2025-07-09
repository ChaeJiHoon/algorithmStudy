import java.util.*;
import java.io.*;

public class Main {

    static int N,M;
    static String S, PN;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine();

        PN = makingN(N);

        int answer = 0;
        int pnLength = PN.length();

        for(int i=0;i<=M-pnLength;i++) if(check(i, pnLength)) answer++;

        System.out.println(answer);
    }

    static String makingN(int n){
        StringBuilder s = new StringBuilder();
        s.append("I");

        for(int i=0;i<N;i++) s.append("OI");

        return s.toString();
    }

    static boolean check(int start, int pnL){
        return S.substring(start,start+pnL).equals(PN);
    }
}
