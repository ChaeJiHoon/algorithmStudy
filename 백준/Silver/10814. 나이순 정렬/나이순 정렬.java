import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] ageArr = new String[201][100001];
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<201;i++){
            ageArr[i][0] = "0";
        }

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String b = st.nextToken();

            int count = Integer.parseInt(ageArr[a][0]);         //  카운트 증가 처음은 0->1
            count++;
            ageArr[a][count] = b;                               //  카운트 된 위치에 이름 넣기
            ageArr[a][0] = Integer.toString(count);             //  증가된 카운트 배열에 집어넣기
        }

        for(int i=0;i<201;i++){
            int count = Integer.parseInt(ageArr[i][0]);
            int rCount = Integer.parseInt(ageArr[i][0])-1;

            while(rCount>=0){ // 카운트가 0이 아니면
                sb.append(i).append(" ").append(ageArr[i][count-rCount]).append("\n");
                rCount--;
            }
        }
        System.out.println(sb.toString().trim());

    }
}
