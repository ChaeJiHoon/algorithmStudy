import java.util.*;

class Solution {
    public int solution(String dartResult) {
        String[] dart = dartResult.split("");
        boolean[] check = new boolean[3];
        String[] game = new String[3];
        
        List<Integer> list = new ArrayList<>();
        
        int index=0;
        
        while(index<dart.length){
            
            // 1일때 예외처리
            if(dart[index].equals("1")){
                if(dart[index+1].equals("0")){
                    list.add(func(dart[index+2], 10));
                    index += 3;
                }else{
                    list.add(func(dart[index+1], 1));
                    index += 2;
                }
            }else if(dart[index].equals("*")){
                int n = index/3;
                check[n] = true;
                game[n] = dart[index++];
            }else if(dart[index].equals("#")){
                int n = index/3;
                check[n] = true;
                game[n] = dart[index++];
            }else{
                list.add(func(dart[index+1], Integer.parseInt(dart[index])));
                index+=2;
            }
            
        }
        
        int answer = 0;
        int[] arr = new int[3];
        
        for(int i=0;i<3;i++){
            arr[i] = list.get(i);
            
            if(check[i]){
                if(game[i].equals("*")) {
                    arr[i] = arr[i]*2;
                    if(i!=0) arr[i-1] = arr[i-1]*2;               
                }
                else arr[i] = -(arr[i]);
            }
        }
        
        for(int i : arr) answer += i;
        
        return answer;
    }
    
    static int func(String s, int num){
        if(s.equals("S")) return num;
        else if(s.equals("D")) return num*num;
        else return num*num*num;
    }
}