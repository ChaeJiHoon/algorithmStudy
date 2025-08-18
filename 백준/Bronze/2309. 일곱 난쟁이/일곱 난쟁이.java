import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        int cnt = 0;
        for(int i=0;i<9;i++){
            int n = Integer.parseInt(br.readLine());
            list.add(n);
            cnt += n;
        }

        Collections.sort(list);

        for(int i=0;i<9;i++){
            int num = list.get(i);
            for(int j=0;j<9;j++){
                if(list.get(j)==num) continue;
                if(100 == cnt-(num+list.get(j))){
                    list.remove(j);
                    list.remove(i);
                    for(Integer index : list) sb.append(index).append("\n");
                    System.out.println(sb.toString());
                    return;
                }
            }
        }
    }
}
