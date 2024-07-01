class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int num1 = 1;
        int num2 = 0;
        for(int i=0;i<num_list.length;i++){
            num1 = num1*num_list[i];
            num2 += num_list[i];
        }
        
        return (num1>num2*num2) ? 0 : 1;
    }
}