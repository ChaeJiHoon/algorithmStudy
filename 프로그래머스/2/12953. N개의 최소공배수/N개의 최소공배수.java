import java.util.*;

class Solution {
    public int solution(int[] arr) {
        
        Arrays.sort(arr);

        for(int i=0;i<arr.length-1;i++){
            int a = arr[i];
            int b = arr[i+1];
            
            int indexA = 1;
            int indexB = 1;
            
            while(a*indexA!=b*indexB){
                if(a*indexA<b*indexB) indexA++;
                else indexB++;
            }
            
            arr[i+1] = a*indexA; 
            
        }
        int answer = arr[arr.length-1];
        return answer;
    }
}