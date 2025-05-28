package bruteForce;
// 백준 | 브루트포스 | 실버5
// 1436 번 : 영화감독 숌
// 시간 제한 : 2초, 메모리 제한 : 128 MB
// 25.05.28
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class FlimDirectorShom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        int[] arr = new int[10001];
        int cnt = 0;

        while(q.size()<10000){
            cnt++;
            if(Integer.toString(cnt).contains("666")) q.add(cnt);
        }

        for(int i=1;i<=10000;i++){
            arr[i] = q.poll();
        }

        System.out.println(arr[Integer.parseInt(br.readLine())]);
    }
}
