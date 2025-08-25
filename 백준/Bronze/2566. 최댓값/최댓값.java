import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max=0,s=0, maxS=1, maxC=1;

        for(int i=1;i<=9;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c=0;
            s++;
            for(int j=1;j<=9;j++){
                c++;
                int num = Integer.parseInt(st.nextToken());

                if(max<num){
                    max = num;
                    maxS = s;
                    maxC = c;
                }
            }
        }
        System.out.println(max);
        System.out.print(maxS + " "+ maxC);
    }
}