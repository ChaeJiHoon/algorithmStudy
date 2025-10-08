import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        char[] ans = br.readLine().toCharArray();

        for(int i=0;i<T-1;i++){
            String str = br.readLine();

            for(int j=0;j<str.length();j++) if(ans[j]!=str.charAt(j)) ans[j] = '?';
        }

        System.out.println(new String(ans));
    }

}