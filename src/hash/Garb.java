// 프로그래머스 Hash
// 단계 2, 의상

package hash;
import java.util.HashMap;


public class Garb {
    public static void main(String[] args) {
        String[][] str = new String[3][2];

        str[0][0] = "yellow_hat";
        str[0][1] = "headgear";
        str[1][0] = "blue_sunglasses";
        str[1][1] = "eyewear";
        str[2][0] = "green_turban";
        str[2][1] = "headgear";

        System.out.println(solution(str));

    }


    public static int solution(String[][] clothes){

        // 저장을 위한 해시 맵
        HashMap<String, Integer> map = new HashMap<>();

        //조합 구현을 위해 1로 초기화
        int answer =1;

        // 의상 종류별로 세기
        // ex) str[1] : headgear
        // getOrDefaults(key, drfaultValue) : key-> 찾고자 하는 키, defaultValue-> 해당 키가 없을때 반환할 기본값
        for (String[] s: clothes) {
            map.put(s[1], map.getOrDefault(s[1], 0) + 1);
        }

        // 조합 계산
        for (String s : map.keySet()) {
            answer *= (map.get(s) + 1);
        }

        // 아예 안입는 경우의 수 제외
        answer--;

        return answer;
    }
}
