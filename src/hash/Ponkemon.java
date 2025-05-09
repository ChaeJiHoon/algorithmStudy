package hash;

import java.util.HashSet;
import java.util.Set;

public class Ponkemon {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,2};
        System.out.println(solution(nums));
    }
    private static int solution(int[] nums){
        int answer=0;
        int bestCase;
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        if(set.size()>= nums.length/2) return answer = nums.length/2;
        else{
            return answer = set.size();
        }

    }
}
