package dfs;
// 프로그래머스 타겟 넘버, 단계 2
// dFS 문제, 해결법 2번째

public class TargetNumber2 {
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        System.out.println(solution(numbers,3));
    }

    public static int solution(int[] numbers, int target){

        return dfs(0,numbers,target,0);
    }

    private static int dfs(int depth, int[] numbers, int target, int sum){
        if(depth == numbers.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }

        return dfs(depth +1, numbers,target,sum+numbers[depth]) + dfs(depth +1, numbers,target,sum-numbers[depth]);

    }
}
