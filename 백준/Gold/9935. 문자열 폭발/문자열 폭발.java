import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bomb = br.readLine();
        int m = bomb.length();

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++) {
            sb.append(s.charAt(i));

            if (sb.length()>=m){
                boolean trigger = true;
                for (int j=0;j<m;j++){
                    if(sb.charAt(sb.length()-m+j) != bomb.charAt(j)){
                        trigger = false;
                        break;
                    }
                }
                if (trigger) sb.setLength(sb.length() - m);
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}
