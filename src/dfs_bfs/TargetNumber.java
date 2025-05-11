package dfs_bfs;
// 프로그래머스 타겟 넘버, 단계 2
// DFS 문제

public class TargetNumber {
    static int answer=0;
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        System.out.println(solution(numbers,3));
    }

    public static int solution(int[] numbers, int target){
        dfs(0,numbers,target,0);
        return answer;
    }

    private static void dfs(int depth, int[] numbers, int target, int sum){
        if(depth == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        dfs(depth +1, numbers,target,sum+numbers[depth]);
        dfs(depth +1, numbers,target,sum-numbers[depth]);
    }
}
