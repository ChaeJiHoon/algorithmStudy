import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    public static void main(String[] args) throws Exception{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=1;i<=N;i++){
            List<Integer> list = new ArrayList<>();
            list.add(i);
            backDfs(list,1, i+"");
        }

    }

    static void backDfs(List<Integer> prelist, int visitNum, String prestr){
        if(visitNum==M) {
            System.out.println(prestr);
            return;
        }

        for(int i=1;i<=N;i++){
            List<Integer> newList = new ArrayList<>(prelist);   // 보낼 리스트
            String newstr = "";

            if(!prelist.contains(i)){                              // 확인할 리스트에 없으면
                newList.add(i);
                newstr = prestr + " " + i;
                backDfs(newList,visitNum+1,newstr);
            }

        }
    }
}
