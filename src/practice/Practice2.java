package practice;
import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Practice2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        int a = 0;
        int LNum = 0;
        int GNum = max;

        // 최소 최대 구해서 계산을 편하게 하기 위함
        if(min>max) {
            a = min;
            min = max;
            max = a;
        }

        // 최소공배수 구하기
        for(int i=1;i<=min;i++){
            if(min%i==0 && max%i==0) LNum = i;
        }
        System.out.println(LNum);

        while(true){
            if(GNum%max==0 && GNum%min==0) break;
            GNum++;
        }
        System.out.println(GNum);

    }
}
