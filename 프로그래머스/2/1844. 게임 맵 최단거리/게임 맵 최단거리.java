import java.util.*;

class Solution {
    int[] dx = {1,0,-1,0};   // 우, 좌
    int[] dy = {0,1,0,-1};   // 하, 상
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int[][] visited_Arr = new int[maps.length][maps[0].length];  // 방문한 위치를 기록하는 배열, 모두 0으로 초기화
        
        bfs(maps, visited_Arr);         // bfs 탐색, 경로 탐색에는 bfs가 유리
        
        answer = visited_Arr[maps.length-1][maps[0].length-1];  // 상대 팀 진영
        
        if(answer ==0){     //상대 팀 진영에 도착하지 못한 경우 0일거임, answer -1로 리턴
            answer = -1;
        }
        
        return answer;
    
    }
    
    void bfs(int maps[][], int[][] visited_Arr){
        
        Queue<int[]> q = new LinkedList<>();    // 배열을 넣는 큐 생성
        q.add(new int[]{0,0});                  // 큐에 정점 추가
        visited_Arr[0][0] = 1;                  // 시작 좌표를 들린걸 표시하기 위해 1 남김
        
        while(!q.isEmpty()){
            int[] current = q.poll();            // 정점 하나 꺼내기, 첫번째 정점은 [0,0]이고
                
            int X = current[0];                 // 이를 X, Y에 각각 넣고 시작한다
            int Y = current[1];
            
            for(int i=0; i<4;i++){              // for문에서 X 값과 Y 값 좌표를 바꿔가면서 진행
                int nx = X + dx[i];
                int ny = Y + dy[i];
                
                if(nx<0 || nx>maps.length-1 || ny<0 ||ny >maps[0].length-1){
                    continue; // 좌표가 범위를 벗어나면 넘어감
                }
                
                if(visited_Arr[nx][ny] ==0 && maps[nx][ny] == 1){
                    visited_Arr[nx][ny] = visited_Arr[X][Y] + 1;
                    q.add(new int[]{nx,ny});
                }
                
            }
        }
        
    }
    
}