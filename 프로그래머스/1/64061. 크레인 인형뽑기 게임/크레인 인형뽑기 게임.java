import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        Stack<Integer>[] boards = new Stack[board[0].length];
        for(int i=0;i<board[0].length;i++) boards[i] = new Stack<>();
        
        // 인덱스 처리
        for(int i=0;i<moves.length;i++) moves[i]--;
        
        // board 처리
        for(int i=0;i<board[0].length;i++){
            for(int j=board.length-1;j>=0;j--){
                int n = board[j][i];
                if(n==0) break;
                boards[i].add(n);
            }
        }
        
        int answer = 0;
        
        // 여기가 시뮬레이션
        for(int i=0;i<moves.length;i++){
            int order = moves[i];
            
            // 인형뽑기
            if(!boards[order].isEmpty()){
                int doll = boards[order].pop();
                //System.out.println(doll);
                
                if(!dq.isEmpty() && dq.peekLast()==doll){
                    dq.pollLast();
                    answer += 2;
                }else dq.add(doll);
            }
            
            
        }
        
        
        
        return answer;
    }
}
