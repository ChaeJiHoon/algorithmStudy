import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited = new boolean[10000];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startNum = Integer.parseInt(st.nextToken());
            int targetNum = Integer.parseInt(st.nextToken());
            sb.append(bfs(startNum, targetNum)).append("\n");
        }

        System.out.println(sb.toString());
    }

    static String bfs(int start, int target){
        Arrays.fill(visited,false);
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start,""));
        visited[start] = true;

        while(!q.isEmpty()){
            Node curr = q.poll();

            if(curr.num == target) return curr.command;
            
            int d = (curr.num*2)%10000;
            if (!visited[d]){
                visited[d] = true;
                q.offer(new Node(d, curr.command+"D"));
            }
            
            int s = (curr.num==0) ? 9999 : curr.num-1;
            if(!visited[s]){
                visited[s] = true;
                q.offer(new Node(s, curr.command+"S"));
            }
            
            int l = (curr.num%1000)*10+(curr.num/1000);
            if(!visited[l]){
                visited[l] = true;
                q.offer(new Node(l, curr.command+"L"));
            }
            
            int r =(curr.num % 10)*1000+(curr.num/10);
            if(!visited[r]){
                visited[r] = true;
                q.offer(new Node(r, curr.command+"R"));
            }
        }

        return "";

    }

    static class Node{
        int num;
        String command;

        Node(int num, String command){
            this.num = num;
            this.command = command;
        }
    }
}
