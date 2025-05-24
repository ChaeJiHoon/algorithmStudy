package greedy;
// 프로그래머스 | 그리디 | Lv.1
// 탐욕법(Greedy) : 체육복
// 25.05.22

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SportWear {
    public static void main(String[] args) {
        Spo sp = new Spo();
        int[] lost = {1,3,4,5,6,10,14};
        int[] reserve = {2,7,8,12,13};
        System.out.println(sp.solution(15, lost, reserve));
    }
}

class Spo {
    public int solution(int n, int[] lost, int[] reserve) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[n+2];
        int count = 0;

        for(int i=0;i<arr.length;i++)  {       // 일단 다 1로 초기화
            arr[i] = 1;
        }

        for(int i=0;i<reserve.length;i++){     // 2개챙긴 애들은 2
            arr[reserve[i]] = 2;
        }

        for(int i=0;i<lost.length;i++){     // 잃어버린애들은 -1
            arr[lost[i]] -= 1;
        }




        for(int i=1;i<arr.length-1;i++){
            System.out.println("변하기 전 : arr[" + (i-1) + "] : " + arr[(i-1)]);
            System.out.println("변하기 전 : arr[" + i + "] : " + arr[i]);
            System.out.println("변하기 전 : arr[" + (i+1) + "] : " + arr[(i+1)]);
            if(arr[i]==2){                  // 여분있는애 발견
                if(arr[i-1]==0){            // 여분있는애 앞친구가 빈경우
                    arr[i-1] = 1;           // 없는애 1개 주고
                    arr[i] = 1;             // 여분있던애 1개됨
                }else{                      // 여분있는애 앞친구는 있는 경우
                    if(arr[i+1]==0){        // 여분있는애 뒷친구 확인해서 빈경우
                        arr[i+1] = 1;       // 없는애 1개 주고
                        arr[i] = 1;         // 여분있던애 1개됨
                    }
                }
            }
            System.out.println("변한 후 : arr[" + (i-1) + "] : " + arr[(i-1)]);
            System.out.println("변한 후 : arr[" + i + "] : " + arr[i]);
            System.out.println("변한 후 : arr[" + (i+1) + "] : " + arr[(i+1)]);
            System.out.println();
        }

        for(int i=1;i<arr.length-1;i++) {
            if(arr[i]==1 || arr[i]==2) count++;
        }

        return count;
    }
}
