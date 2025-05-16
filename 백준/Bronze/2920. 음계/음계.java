import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        int dcount = 0;

        int pre = Integer.parseInt(st.nextToken());

        for(int i=0; i<7;i++){
            int num = Integer.parseInt(st.nextToken());
            if(pre == 8 && num == 1) count++;
            if(pre == 1 && num == 8) dcount++;
            else{
                if(num == pre+1) count++;
                if(num == pre-1) dcount++;
            }
            pre = num;
        }
        
        if(count == 7) System.out.println("ascending");
        else if(dcount == 7) System.out.println("descending");
        else System.out.println("mixed");
    }
}
