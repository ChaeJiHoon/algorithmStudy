import java.io.*;

public class Main {

    static int N,M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int answer = 0;
        int count = 0;
        int i=1;

        while(i<M-1){
            // "IOI" 패턴 발견
            if(S.charAt(i-1)=='I'&&S.charAt(i)=='O'&&S.charAt(i+1)=='I'){
                count++; // OI 쌍 하나 발견
                if(count == N) {
                    answer++;
                    count--; // 겹치는 경우 고려
                }
                i+=2; // 다음 'I'부터 확인
            }else{
                count = 0;
                i++;
            }
        }
        System.out.println(answer);
    }

}
