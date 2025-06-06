package implement;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class NLeastCommon {
    public static void main(String[] args) {
        int[] arr = {2,6,8,14};
        System.out.println(Solution.solution(arr));

    }
}

class Solution {
    static HashMap<Integer,Integer> map = new HashMap<>();
    public static int solution(int[] arr) {
        for(int i=0;i<arr.length;i++){
            HashMap<Integer,Integer> nMap = new HashMap<>();
            int num = 2;
            //System.out.print("arr["+i+"] : " + arr[i] + " : ");
            while(arr[i]>1){
                if(arr[i]%num==0) {
                    arr[i] = arr[i]/num;
                    nMap.put(num, nMap.getOrDefault(num,0)+1);
                    num=2;
                }else num++;
            }

            // 해시 키 가져와서 큐에 넣고
            Queue<Integer> q = new LinkedList<>(nMap.keySet());
            int l = q.size();

            for(int j=0;j<l;j++){
                int a = q.poll();                                       // 큐에서 꺼내면서
                if(map.containsKey(a)){                                 // 기존 맵에 있는지 확인하고
                    if(map.get(a) < nMap.get(a)) map.put(a,nMap.get(a)); // 기존 해시 맵에 있는 것 보다, 새 해시맵에 있는 소수가 더 큰 경우 교체
                }
                else map.put(a,nMap.get(a));                            // 없으면 그냥 넣음
            }

        }
        Queue<Integer> nq = new LinkedList<>(map.keySet());
        int size = nq.size();
        for(int i=0;i<size;i++){
            int a = nq.poll();
            int b = map.get(a);
            for(int j=0;j<b;j++){
                a *= a;
            }
        }


        int answer = 0;
        return answer;
    }
}