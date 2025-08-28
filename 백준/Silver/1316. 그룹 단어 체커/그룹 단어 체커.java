import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = N;

        for(int i=0;i<N;i++) {
            Set<Character> set = new HashSet<>();
            String str = br.readLine();
            char preC = str.charAt(0);
            set.add(preC);
            for (int j=1; j<str.length();j++) {
                // 이전단어와 다르면서 set에 있는 경우
                if (preC!=str.charAt(j)&&set.contains(str.charAt(j))) {
                    answer--;
                    break;
                }
                preC = str.charAt(j);
                set.add(preC);
            }
        }

        System.out.println(answer);
    }
}