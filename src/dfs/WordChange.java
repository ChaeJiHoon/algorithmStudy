package dfs;
// 프로그래머스 | dfs_bfs | 레벨 3
// 알고리즘 키트 : 단어 변환
// 25.05.29
class WordChange {
    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(Solution.solution("hit", "cog", words));
    }
}

class Solution {

    static String[] wordsArr;
    static int answer = 0;

    static int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        wordsArr = words;
        answer = wordsArr.length;
        // 1. target이 words 안에 있는지 판단
        int cnt = 0;
        for(String str : words){
            if(target.equals(str)) break;
            else cnt++;
        }
        if(cnt==words.length) return 0; // 없는 경우 반환

        dfs(begin, target,0, visited);

        if(answer== wordsArr.length) return 0;
        return answer;
    }

    // 매개 변수 : 이전 단어, 타겟, dfs 호출 횟수, 이전까지 방문 배열
    static void dfs(String pre, String target, int count, boolean[] visited){
        boolean[] newVisited = new boolean[wordsArr.length];
        for(int i=0;i<wordsArr.length;i++) newVisited[i] = visited[i];

        // 이전 단어와의 비교
        for(int i=0;i<wordsArr.length;i++){
            int sCnt = 0;
            int tCnt = 0;
            for(int j=0;j<pre.length();j++){

                // 이전 단어와 몇개 같은지 비교
                if(pre.charAt(j)==wordsArr[i].charAt(j)) {
                    sCnt++;
                }
                // 이전 단어와 타겟 비교
                if(pre.charAt(j)==target.charAt(j)) tCnt++;
            }
            // 현재 단어와 타겟이 같은 경우
            // answer 보다 카운트가 작을 경우 반환
            if(tCnt==wordsArr[i].length()) {
                if(answer>count) answer = count;
                return;
            }

            // 현재 단어가 이전 비교 단어와 1개만 다르면서 방문 안한 경우만 호출
            if(sCnt==wordsArr[i].length()-1 && !newVisited[i]) {
                newVisited[i] = true;
                dfs(wordsArr[i], target, ++count, newVisited);
                count--;
            }

        }
    }
}