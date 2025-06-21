package Sort;
// 프로그래머스 | 정렬 | Lv 2
// 문제 : 가장 큰 수
// 25.06.08
import java.util.*;

public class BiggestNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{3, 30, 34, 5, 9}));
    }


}

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        int nLength = numbers.length;
        String[] nums = new String[nLength];

        for(int i=0;i<nLength;i++){
            nums[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(nums, (o1, o2) ->(o2+o1).compareTo(o1+o2));

        if(nums[0].equals("0")) return "0";

        for (String num : nums) {
            sb.append(num);
        }

        return sb.toString();
    }
}