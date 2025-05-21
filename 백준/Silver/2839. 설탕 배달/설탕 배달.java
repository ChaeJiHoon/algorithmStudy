import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(func(n));
    }

    public static int func(int n){  
        int count = n/5;     
        int m = 0;          

        for(int i=count;i>=0;i--){
            m = 5*i; 
            for(int j=0;j<=4;j++){
                if(m+j*3==n) return i+j;
                if(m+j*3>n) break;
            }
        }
        return -1;
    }
}
