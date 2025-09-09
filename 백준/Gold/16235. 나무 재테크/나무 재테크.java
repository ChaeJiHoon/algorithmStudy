import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int[][] A;
    static List<Integer>[][] tree;
    static Queue<int[]> summerQ = new LinkedList<>();
    static int N,M,K;
    static int[] dx = {-1,0,1,1,1,0,-1,-1};
    static int[] dy = {-1,-1,-1,0,1,1,1,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        A = new int[N+1][N+1];
        tree = new List[N+1][N+1];

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++) map[i][j] = 5;
        }

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) A[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<=N;i++){
            for(int j=0;j<=N;j++) tree[i][j] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            tree[y][x].add(z);
        }

        while(K-->0){
            spring();
            summer();
            autumn();
            winter();
        }
        
        int cnt = 0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++) cnt += tree[i][j].size();
        }
        System.out.println(cnt);
    }

    static void spring(){
        // 나무 나이 먹기
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++) {
                if(!tree[i][j].isEmpty()){
                    Collections.sort(tree[i][j]);       // 제일 어린 애들 부터 양분 먹기 위함

                    for(int t=0;t<tree[i][j].size();t++){

                        int age = tree[i][j].get(t);
                        // 나이가 양분보다 많은 경우 다 죽음
                        // 죽으면 양분 돌려줌
                        if(age>map[i][j]){
                            int len =  tree[i][j].size() - t;
                            for(int l=0;l<len;l++) summerQ.add(new int[]{i,j,tree[i][j].remove(t)});
                            break;
                        }else{
                            map[i][j] -= age;
                            tree[i][j].set(t,tree[i][j].get(t)+1);  // 한살 더 먹음
                        }
                    }
                }
            }
        }
    }

    static void summer(){
        // 뒤진 나무들 다 양분 ㄱㄱ
        while(!summerQ.isEmpty()){
            int[] dieTree = summerQ.poll();

            int y = dieTree[0];
            int x = dieTree[1];
            int z = dieTree[2];

            map[y][x] += z/2;

        }
    }

    static void autumn(){

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++) {
                for(int age : tree[i][j]){
                    if(age%5==0){   // 5년차 나무
                        // 모서리 아니면 나무 심음
                        for(int l=0;l<8;l++){
                            int nY = i+dy[l];
                            int nX = j+dx[l];

                            if(nY<=0 || nX<=0 || nY>N || nX>N) continue;
                            tree[nY][nX].add(1);
                        }

                    }
                }
            }

        }


    }

    static void winter(){
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++) map[i][j] += A[i][j];
        }
    }
}