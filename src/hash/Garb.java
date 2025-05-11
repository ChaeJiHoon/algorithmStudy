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

        solution(str);


    }


    public static int solution(String[][] clothes){
        HashMap<String, String> map = new HashMap<>();
        int answer =0;

        for(int i=0;i<clothes.length;i++){
            map.put(clothes[i][0],clothes[i][1]);
        }

        for (String key : map.keySet()) {

        }

        return answer;
    }
}
