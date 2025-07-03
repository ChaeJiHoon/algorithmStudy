import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;

    static HashMap<Integer, Integer> ladders = new HashMap<>();
    static boolean[] visited = new boolean[101]; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N+M;i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            ladders.put(to,from);
        }

        System.out.println(bfs());
    }


    static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,0});

        while(!q.isEmpty()){
            int[] arr = q.poll();
            visited[arr[0]] = true;
            if(arr[0] == 100) return arr[1];

            for(int i=1;i<=6;i++){
                if(arr[0]+i<=100 && !visited[arr[0]+i]){
                    if(ladders.containsKey(arr[0]+i)) q.add(new int[]{ladders.get(arr[0]+i),arr[1]+1});
                    else q.add(new int[]{arr[0]+i,arr[1]+1});
                }
            }
        }
        return -1;
    }
}