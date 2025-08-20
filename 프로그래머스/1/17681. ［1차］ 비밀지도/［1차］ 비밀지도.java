import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[][] map1 = new String[n][n];
        String[][] map2 = new String[n][n];
        
        // 0으로 다 채워놓고
        for(int i=0;i<n;i++){
            Arrays.fill(map1[i],"0");
            Arrays.fill(map2[i],"0");
        } 
        
        for(int i=0;i<n;i++){
            String[] s1 = Integer.toBinaryString(arr1[i]).split("");
            String[] s2 = Integer.toBinaryString(arr2[i]).split("");
            
            for(int j=n-1;j>=n-s1.length;j--) map1[i][j] = s1[j-(n-s1.length)];
            for(int j=n-1;j>=n-s2.length;j--) map2[i][j] = s2[j-(n-s2.length)];
            
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map1[i][j].equals("1") || map2[i][j].equals("1")) map1[i][j] = "#";
                else map1[i][j] = " ";
            }
        }
        
        String[] answer = new String[n];
        
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++) sb.append(map1[i][j]);
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}