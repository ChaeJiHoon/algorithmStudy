package hash;

import java.util.*;

public class BestAlbum {
    public static void main(String[] args){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(Solution.solution(genres, plays)));   // [4, 1, 3, 0]
    }
}

class Solution {
    static int[] solution(String[] genres, int[] plays) {
        // 답변으로 제출할 list 생성, 나중에 배열로 변환하여 제출
        ArrayList<Integer> answer = new ArrayList<>();

        // 장르, 장르 누적 횟수 저장할 해시맵, 나중에 꺼내서 시간 비교하는데 쓰일 거임
        HashMap<String,Integer> musicPlay = new HashMap<>();

        // 장르, 해시<고유번호, 플레이 횟수>, 이것도 나중에 꺼내서 장르별 가장 많이 플레이 된거 확인하려고 쓰임
        HashMap<String, HashMap<Integer,Integer>> musicNumberPlay = new HashMap<>();

        // 장르 누적 횟수 구하기 시작
        for(int i=0;i<genres.length;i++){

            // 장르가 맵에 없는 경우
            if(!musicPlay.containsKey(genres[i])) {
                // musicNumberPlay 에 넣을 맵 생성
                HashMap<Integer,Integer> map = new HashMap<>();

                // musicNumberPlay에 저장
                map.put(i,plays[i]);
                musicNumberPlay.put(genres[i],map);

                // 장르 처음으로 맵에 저장
                musicPlay.put(genres[i],plays[i]);

            }else{// 장르가 맵에 있는 경우
                // musicNumberPlay.get(genres[i]) : 바깥 해시맵에서 해당 장르에 해당하는 내부 해시맵을 가져옴
                // 가져온 해시맵 ex) musicNumberPlay.get("pop") → {0: 500, 3: 250} (노래 번호와 재생 수)
                // .put(i, plays[i]) : 가져온 해시맵에 자료 저장

                /* musicNumberPlay.get("pop").put(4, 300); -> "pop": {0: 500, 3: 250, 4: 300} */
                musicNumberPlay.get(genres[i]).put(i,plays[i]);

                // 기존 누적 시간과 현재 시간을 더해서 갱신
                musicPlay.put(genres[i], musicPlay.get(genres[i])+plays[i]);
            }

        }
        // 크기 순 정렬을 위해 누적시간 맵의 키들을 불러온다
        List<String> keyset = new ArrayList<>(musicPlay.keySet());


        // 내림 차순 정렬
        // 여기가 제일 중요한 문법이다
        // keyset에서 가져온 s1,s2 즉, s1, s2는 장르들이다.
        // 여기서 장르별 누적시간이 가져온 해시 맵 musicPlay의 키를 넣어 나온 밸류를 가지고 내림차순 정렬을 진행
        Collections.sort(keyset,(s1,s2)
                -> musicPlay.get(s2) - musicPlay.get(s1));
        // 이러면 이제 장르별로 누적시간이 긴 순서대로 정렬이 완료된 상태이다.


        // 이제 장르 내에서 긴 순서대로 2개 뽑아서 정렬할 차례!
        for (String key : keyset) {
            // keyset은 정렬되어 있는 상태, 따라서 누적 횟수가 가장 큰 장르 부터 순회
            // 따라서 map을 하나 새로 생성하고, 거기에 가장 누적횟수가 큰 장르부터 뽑아서 고유번호, 플레이 시간을 넣는다,
            HashMap<Integer,Integer> map = musicNumberPlay.get(key);

            // 장르 고유번호를 저장하는 리스트를 생성
            List<Integer> genre_key = new ArrayList<>(map.keySet());

            // 장르 내 고유번호를 가지고, 맵에 넣어서
            // 플레이 횟수가 큰 순서대로, 고유번호를 정렬
            // 정말 중요하고 이해 많이 필요함
            Collections.sort(genre_key,(o1,o2)->
                    map.get(o2)-(map.get(o1)));

            // 정렬된 고유번호 1번째 꺼는 무조건 넣고
            answer.add(genre_key.get(0));
            // 만약 고유번호가 2개 이상이면, 2번째 꺼 넣어서
            if(genre_key.size()>1){
                answer.add(genre_key.get(1));
            }
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}