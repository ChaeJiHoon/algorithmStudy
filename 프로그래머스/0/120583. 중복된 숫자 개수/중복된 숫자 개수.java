class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        for(int i : array) if(n==i) answer++;
        return answer;
    }
}