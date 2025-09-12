import java.util.*;

class Solution {
    static char[][] map;
    static int r,c;
    static int cnt = 0;
    public int solution(int m, int n, String[] board) {
        r = board.length;
        c = board[0].length();
        map = new char[r][c];
        
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) map[i][j] = board[i].charAt(j);
        }
        
        boolean trigger = true;
        
        while(trigger){
            trigger = del(false);
            if(trigger)func();
        }
        
        return cnt;
    }
    
    // 1. 삭제가 있었는지 확인
    // 2. 삭제가 있는 경우 삭제
    static boolean del(boolean trigger){
        boolean[][] checked = new boolean[r][c];
        
        for(int i=0;i<r-1;i++) {
            for(int j=0;j<c-1;j++) {
                char c = map[i][j];
                
                if(c!='0'&& c==map[i][j+1] && c==map[i+1][j] && c==map[i+1][j+1]){
                    trigger = true;
                    checked[i][j] = true;
                    checked[i+1][j] = true;
                    checked[i][j+1] = true;
                    checked[i+1][j+1] = true;
                }
            }
        }
        
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(checked[i][j]){
                    map[i][j] = '0';
                    cnt++;
                } 
            }
        }
        
        return trigger;
    }
    
    static void func(){
        Queue<Character>[] q = new LinkedList[c];
        
        for(int i=0;i<c;i++) q[i] = new LinkedList<>();
        
        for(int j=0;j<c;j++) {
            for(int i=r-1;i>=0;i--) {
                if(map[i][j]!='0') q[j].add(map[i][j]);
            }
        }
        
        map = new char[r][c];
        
        for(int i=0;i<r;i++) {
            Arrays.fill(map[i],'0'); 
        }
        
        for(int j=0;j<c;j++) {
            int index = r-1;
            
            while(!q[j].isEmpty()){
                map[index--][j] = q[j].poll();
            }
        }
        
    }
    
  
}