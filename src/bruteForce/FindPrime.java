package bruteForce;
// 프로그래머스 | 소수 찾기 | 레벨2
// 완전 탐색 : 소수 찾기
// 25.05.30, 소수 찾는 방법 공부하기..
import java.util.LinkedList;
import java.util.Queue;

public class FindPrime {
    public static void main(String[] args) {
        int a = Solution.solution("011");
        System.out.println(a);
    }
}

class Solution {
    static boolean[] prime  = new boolean[10_000_000];
    public static int solution(String numbers) {
        prime[0] = true;
        prime[1] = true;
        int num = (int)Math.sqrt(10000000);
        Queue<Integer> q = new LinkedList<>();

        // 천재...
        for(int i=2;i<num;i++){
            if(prime[i]) continue;

            for(int j = i * i; j < prime.length; j = j+i) {
                prime[j] = true;
            }
        }

        for(int i=0;i<prime.length;i++){
            if(!prime[i]) q.add(i);
        }


        int size = q.size();

        int[][] arr = new int[size+1][10];

        for(int i=0;i<=size;i++){
            String str;
            if(i==0)  str = numbers;
            else str = String.valueOf(q.poll());

            for(int j=0;j<str.length();j++){
                switch (str.charAt(j)) {
                    case '0' : arr[i][0]++;break;
                    case '1' : arr[i][1]++;break;
                    case '2' : arr[i][2]++;break;
                    case '3' : arr[i][3]++;break;
                    case '4' : arr[i][4]++;break;
                    case '5' : arr[i][5]++;break;
                    case '6' : arr[i][6]++;break;
                    case '7' : arr[i][7]++;break;
                    case '8' : arr[i][8]++;break;
                    case '9' : arr[i][9]++;break;
                }
            }
        }

        int answer = 0;
        for(int i=1;i<arr.length;i++){
            int cnt = 0;
            for(int j=0;j<=9;j++){
                if(arr[0][j]<arr[i][j]) cnt++;
            }
            if(cnt==0) answer++;
        }
        return answer;
    }
}
