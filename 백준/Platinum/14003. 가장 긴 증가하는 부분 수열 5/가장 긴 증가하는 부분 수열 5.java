import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[] arr, index;
    static ArrayList<Integer> sequence = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];           // 입력 수열
        index = new int[N];         // 각 원소가 LIS의 어느 인덱스에 포함됐는지 저장

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

        // LIS 수열 만들기 (이분 탐색 사용)
        sequence.add(arr[0]); // 최초 값 삽입
        index[0] = 0;         // arr[0]은 sequence의 0번째 위치에 들어감

        for(int i=1;i<N;i++){
            int now = arr[i];

            if(now>sequence.get(sequence.size()-1)){ // 현재 값이 이전 수열값보다 크다면
                // LIS 수열에 현재 값을 더하고
                sequence.add(now);

                // 현재 값이 들어간 LIS 인덱스를 저장
                index[i] = sequence.size()-1;
            }else{                                       // 현재 값이 이전 수열값보다 같거나 작다면(증가하지 않으면)
                // 배열내 값이 들어갈 위치 반환
                int pos = lowerBound(sequence, now);
                sequence.set(pos,now);
                index[i] = pos;
            }
        }

        // LIS 길이 출력
        System.out.println(sequence.size());

        // LIS 수열 역추적
        Stack<Integer> stack = new Stack<>();
        int len = sequence.size()-1;

        for(int i=N-1;i>=0;i--){
            if(index[i] == len){
                stack.push(arr[i]);
                len--;
            }
        }

        // 수열 출력
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop()).append(" ");

        System.out.println(sb.toString().trim());
    }

    // lowerBound: LIS 배열 내에서 현재 값이 들어갈 가장 작은 위치 반환
    // target 이상인 가장 왼쪽 위치 인덱스를 반환
    private static int lowerBound(ArrayList<Integer> list, int target){
        int left = 0;
        int right = list.size()-1;

        while(left<right){
            int mid = (left+right)/2;
            if(list.get(mid)>=target){
                right = mid;
            }else left = mid+1;
        }
        return right;
    }
}
