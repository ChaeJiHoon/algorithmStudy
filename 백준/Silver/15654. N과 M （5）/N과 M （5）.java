import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        for(int i=0;i<N;i++){
            List<Integer> newList = new ArrayList<>(list);
            backTrackingFunc(newList, newList.remove(i)+"",0);
        }

        System.out.println(sb.toString());
    }

    static void backTrackingFunc(List<Integer> list, String str, int depth){
        depth++;
        if(depth==M){
            sb.append(str).append("\n");
            return;
        }

        for(int i=0;i<list.size();i++){
            List<Integer> newList = new ArrayList<>(list);
            backTrackingFunc(newList, str+" "+newList.remove(i),depth);
        }
    }
}