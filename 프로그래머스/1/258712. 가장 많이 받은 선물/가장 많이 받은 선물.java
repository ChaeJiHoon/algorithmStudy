import java.util.*;

class Solution {

    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;

        // 주고받은 선물 기록
        Map<String, Map<String, Integer>> presentMap = new HashMap<>();
        // 선물 지수
        Map<String, Integer> giftScore = new HashMap<>();
        // 다음 달 받을 선물 수
        Map<String, Integer> receiveCount = new HashMap<>();

        for (String friend : friends) {
            presentMap.put(friend, new HashMap<>());
            giftScore.put(friend, 0);
            receiveCount.put(friend, 0);
        }

        // 주고받은 선물 기록 + 선물 지수 계산
        for (String gift : gifts) {
            String[] split = gift.split(" ");
            String from = split[0];
            String to = split[1];

            presentMap.get(from).put(to, presentMap.get(from).getOrDefault(to, 0) + 1);

            giftScore.put(from, giftScore.get(from) + 1);
            giftScore.put(to, giftScore.get(to) - 1);
        }

        // 친구 쌍 비교
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String A = friends[i];
                String B = friends[j];

                int giftAtoB = presentMap.get(A).getOrDefault(B, 0);
                int giftBtoA = presentMap.get(B).getOrDefault(A, 0);

                if (giftAtoB > giftBtoA) {
                    receiveCount.put(A, receiveCount.get(A) + 1);
                } else if (giftBtoA > giftAtoB) {
                    receiveCount.put(B, receiveCount.get(B) + 1);
                } else {
                    // 선물 지수 비교
                    if (giftScore.get(A) > giftScore.get(B)) {
                        receiveCount.put(A, receiveCount.get(A) + 1);
                    } else if (giftScore.get(A) < giftScore.get(B)) {
                        receiveCount.put(B, receiveCount.get(B) + 1);
                    }
                    // 같으면 아무도 받지 않음
                }
            }
        }

        // 최대값 구하기
        int max = 0;
        for (String friend : friends) {
            max = Math.max(max, receiveCount.get(friend));
        }

        return max;
    }
}
