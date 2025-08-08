import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        Map<Character, Integer> weightMap = new HashMap<>();

        // 1. 알파벳마다 자릿수 가치 누적
        for (String word : words) {
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                int power = (int)Math.pow(10, len - i - 1);
                weightMap.put(c, weightMap.getOrDefault(c, 0) + power);
            }
        }

        // 2. 알파벳 가중치 정렬
        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(weightMap.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue()); // 내림차순

        // 3. 9부터 숫자 부여
        Map<Character, Integer> charToNum = new HashMap<>();
        int num = 9;
        for (Map.Entry<Character, Integer> entry : entries) {
            charToNum.put(entry.getKey(), num--);
        }

        // 4. 전체 숫자 합산
        int sum = 0;
        for (String word : words) {
            int now = 0;
            for (int i = 0; i < word.length(); i++) {
                now = now * 10 + charToNum.get(word.charAt(i));
            }
            sum += now;
        }

        System.out.println(sum);
    }
}
