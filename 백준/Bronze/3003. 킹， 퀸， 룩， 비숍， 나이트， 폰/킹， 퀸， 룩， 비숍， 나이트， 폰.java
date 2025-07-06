import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        sb.append(1-Integer.parseInt(st.nextToken())).append(" ");
        sb.append(1-Integer.parseInt(st.nextToken())).append(" ");
        sb.append(2-Integer.parseInt(st.nextToken())).append(" ");
        sb.append(2-Integer.parseInt(st.nextToken())).append(" ");
        sb.append(2-Integer.parseInt(st.nextToken())).append(" ");
        sb.append(8-Integer.parseInt(st.nextToken()));

        System.out.println(sb.toString());
    }
}