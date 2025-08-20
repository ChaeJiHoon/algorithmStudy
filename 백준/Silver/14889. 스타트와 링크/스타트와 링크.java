import java.io.*;
import java.util.*;

public class Main {
    static int N, min = Integer.MAX_VALUE;
    static int[][] pair;      // 시너지 합 저장
    static boolean[] selected; // 팀 A에 포함된 선수 체크

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] S = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) S[i][j] = Integer.parseInt(st.nextToken());
        }

        // 전처리: S[i][j] + S[j][i]
        pair = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++) pair[i][j] = S[i][j] + S[j][i];
        }

        selected = new boolean[N];
        selected[0] = true; // 0번 선수는 팀 A에 고정 → 탐색 절반 감소

        dfs(1, 1); // idx=1부터 탐색 시작, 현재 팀 A 인원=1
        System.out.println(min);
    }

    // idx: 현재 선수 번호, cnt: 현재까지 팀 A에 포함된 선수 수
    static void dfs(int idx, int cnt){
        // 팀 A가 N/2명이 되면 점수 차이 계산
        if (cnt==N/2){
            calc();
            return;
        }
        if (idx >= N) return;

        // 선택: idx 선수를 팀 A에 포함
        selected[idx] = true;
        dfs(idx+1, cnt+1);

        // 비선택: idx 선수를 팀 B에 포함
        selected[idx] = false;
        dfs(idx+1, cnt);
    }

    // 현재 selected 기준으로 점수 차이 계산
    static void calc(){
        int start=0, link=0;
        for (int i=0;i<N;i++){
            for (int j=i+1;j<N;j++){
                if(selected[i] && selected[j]) start += pair[i][j];
                else if(!selected[i] && !selected[j]) link += pair[i][j];
            }
        }
        min = Math.min(min, Math.abs(start - link));
    }
}
