package greedy;
// 백준 | 그리디 | 실버4
// 11047 번 : 코인0
// 시간 제한 : 1초, 메모리 제한 : 256 MB
// 25.05.22
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Coin0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;

        for(int i=0;i<n;i++){
            stack.add(Integer.valueOf(br.readLine()));
        }

        int num = stack.pop();

        while(k>0){
            if(num>k){                                  // 동전이 금액보다 크면 동전 없애고 다음 동전으로 옮김
                num = stack.pop();
            }else{
                k = k-num;
                count++;
            }
        }
        System.out.println(count);

    }
}
