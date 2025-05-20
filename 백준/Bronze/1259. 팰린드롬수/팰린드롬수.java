import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        do{
            str = br.readLine();
            if(str.equals("0")) break;
            int count = 0;
            if(str.length()%2 == 1){        // 홀수
                for(int i=0;i<str.length()/2;i++){
                    if(str.charAt(i) != str.charAt(str.length()-i-1))count++;
                }
            }else{                          // 짝수
                for(int i=0;i<str.length()/2;i++){
                    if(str.charAt(i) != str.charAt(str.length()-i-1))count++;
                }
            }
            if(count==0) System.out.println("yes");
            else System.out.println("no");

        }while(!str.equals("0"));
    }
}
