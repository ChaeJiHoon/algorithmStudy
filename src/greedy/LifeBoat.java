package greedy;
// 프로그래머스 | 그리디 | Lv.2
// 탐욕법(Greedy) : 구명 보트
// 디버깅용 : System.out.println("arr[0] : " + arr[0] + "\narr[1] : " + arr[1] +"\narr[2] : " + arr[2] +"\narr[3] : " + arr[3]);
// 실패 코드...

import java.util.Arrays;
public class LifeBoat {
    public static void main(String[] args) {
        Solution so = new Solution();
        int[] arr = {70,50,80};
        System.out.println(so.solution(arr,100));
    }
}

class Solution{
    static int[] arr;
    static int lim;
    public int solution(int[] people, int limit){
        arr = people;
        lim = limit;
        int count = 0;
        int index = 0;
        int answer = 0;

        Arrays.sort(arr);

        while(count<arr.length){
            if(arr[index]==0) count++;      // 배열이 쓰인 경우 이미 0일것이다. 그런 경우 count 증가
            else{
                func(index, arr[index]);    // 배열이 안쓰인 경우 함수에 숫자를 넘겨주고
                answer++;                   // 함수 호출 횟수가 답의 수
                index = -1;                 // 인덱스 초기화, 초기화를 통해 다시 앞에서부터 증가
                count = 0;                  // count 초기화, 초기화를 통해 다시 카운트를 셈
            }
            index++;
        }

        return answer;
    }

    public void func(int index, int aPeople){      // 첫번째 사람이 넘어온다.
        arr[index] = 0;                            // 받은 인덱스 배열값 0으로 바꿈
        int bPeople = 0;
        for(int i=arr.length-1;i>=index;i--){          // 큰 값이 있는 배열 맨 뒤부터 순회
            if(arr[i]!=0){                         // 배열 값이 0인 경우 넘어감, 모두 0이면 생략되도록 구현
                bPeople = arr[i];                  // 배열 값이 존재하는 경우 b로 '일단' 저장
                if(aPeople+bPeople<=lim){           // 두 사람 합이 lim 보다 작은 경우
                    arr[i] = 0;                    // 배열값 0으로 바꾸고 종료
                    break;
                }
            }
        }
    }

}