import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            String str = br.readLine();
            int sum=0;
            int count = 0;
            
            for(int j=0;j<str.length();j++){
                if(str.charAt(j) == 'O'){
                    count++;
                    sum += count;
                }else{
                    count = 0;
                }
            }
            System.out.println(sum);
        }
    }
}
