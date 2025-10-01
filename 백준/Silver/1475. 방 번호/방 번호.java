import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer,Integer> map = new HashMap<>();
        String[] str = br.readLine().split("");

        for(String s : str) {
            int N = Integer.parseInt(s);
            map.put(N, map.getOrDefault(N,0)+1);
        }
        int time = 0;

        while(!map.isEmpty()){
            time++;

            for(int i=0;i<=9;i++){
                if(i==6||i==9){
                    if(map.containsKey(6)) {
                        map.put(6, map.getOrDefault(6,map.get(6))-1);
                        if(map.get(6)==0) map.remove(6);
                    }else if(map.containsKey(9)) {
                        map.put(9, map.getOrDefault(9,map.get(9))-1);
                        if(map.get(9)==0) map.remove(9);
                    }
                }else{
                    if(map.containsKey(i)) {
                        map.put(i, map.getOrDefault(i,map.get(i))-1);
                        if(map.get(i)==0) map.remove(i);
                    }
                }
            }

        }
        System.out.println(time);
    }

}