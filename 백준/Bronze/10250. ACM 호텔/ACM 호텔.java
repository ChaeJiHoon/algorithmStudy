import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken()); 
            int N = Integer.parseInt(st.nextToken()); 

            int floor = N % H;
            int room = N / H + 1;

            if (floor == 0) {
                floor = H;
                room = N / H;
            }
            
            System.out.println(floor * 100 + room);
        }
    }
}
