import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int k;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        while(T-->0){
            k = Integer.parseInt(br.readLine());
            TreeMap<Long, Integer> map = new TreeMap<>();
            for(int i=0;i<k;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                long num = Long.parseLong(st.nextToken());

                if(str.equals("I")){  // 삽입
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else if(str.equals("D") && !map.isEmpty()){  // 삭제
                    long key = (num==1) ? map.lastKey() : map.firstKey();
                    if(map.get(key)>1){
                        map.put(key, map.get(key) - 1);
                    } else {
                        map.remove(key);
                    }
                }
            }
            if(!map.isEmpty()){
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }else sb.append("EMPTY\n");

        }

        System.out.println(sb.toString());
    }
}
