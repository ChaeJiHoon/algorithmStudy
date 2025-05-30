package bfs;

class WordChange {
    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(Solution.solution("hit", "cog", words));
    }
}

class Solution {
    //static boolean[] visited;
    static String[] wordsArr;

    static int solution(String begin, String target, String[] words) {
        //visited = new boolean[words.length];
        wordsArr = words;
        // 1. target이 words 안에 있는지 판단
        int cnt = 0;
        for(String str : words){
            if(target.equals(str)) break;
            else cnt++;
        }
        if(cnt==words.length) return 0; // 없는 경우 반환

        return bfs(begin, target, 1);
    }

    static int bfs(String pre, String target, int cnt){

        for(int i=0;i<wordsArr.length;i++){
            int sCnt = 0;
            int tCnt = 0;
            for(int j=0;j<pre.length();j++){
                // 이전 단어와 몇개 같은지 비교
                if(pre.charAt(j)==wordsArr[i].charAt(j)) sCnt++;
                // 타겟과 몇개 같은지 비교
                if(target.charAt(j)==wordsArr[i].charAt(j)) tCnt++;
            }
            // 현재 단어와 타겟이 같은 경우 answer 반환
            if(tCnt==wordsArr[i].length()) return cnt;
            // 현재 단어가 이전 비교 단어와 1개만 다르면서 방문 안한 경우만 호출
            if(sCnt==wordsArr[i].length()-1) {
                bfs(wordsArr[i], target,cnt++);
            }
        }

        return 0;
    }
}