import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int w_long_size = 0;
        int h_long_size = 0;
        int m_long_size = 0;
        int s_size;
        int[] arr = new int[sizes.length];
        
        for(int j=0;j<sizes.length;j++){
            if(w_long_size<sizes[j][0]) w_long_size = sizes[j][0];
            if(h_long_size<sizes[j][1]) h_long_size = sizes[j][1];
            
            if(sizes[j][0]<sizes[j][1]) arr[j] = sizes[j][0];
            else arr[j] = sizes[j][1];
        }
        
        if(w_long_size>h_long_size) m_long_size = w_long_size;
        else m_long_size = h_long_size;
        
       
        Arrays.sort(arr);
        s_size = arr[sizes.length-1];
        
        /*
        for(int i=0;i<sizes.length;i++){
            for(int k=0;k<2;k++){
                if(s_size>sizes[i][k]) s_size = sizes[i][k];
            }
        }*/
        
        return s_size*m_long_size;
    }
}