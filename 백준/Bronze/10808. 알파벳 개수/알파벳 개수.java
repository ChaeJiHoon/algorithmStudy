import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int[] arr = new int[26];
        String[] str = br.readLine().split("");
        
        for(int i=0;i<str.length;i++){
            if(str[i].equals("a")) arr[0]++;
            else if(str[i].equals("b")) arr[1]++;
            else if(str[i].equals("c")) arr[2]++;
            else if(str[i].equals("d")) arr[3]++;
            else if(str[i].equals("e")) arr[4]++;
            else if(str[i].equals("f")) arr[5]++;
            else if(str[i].equals("g")) arr[6]++;
            else if(str[i].equals("h")) arr[7]++;
            else if(str[i].equals("i")) arr[8]++;
            else if(str[i].equals("j")) arr[9]++;
            else if(str[i].equals("k")) arr[10]++;
            else if(str[i].equals("l")) arr[11]++;
            else if(str[i].equals("m")) arr[12]++;
            else if(str[i].equals("n")) arr[13]++;
            else if(str[i].equals("o")) arr[14]++;
            else if(str[i].equals("p")) arr[15]++;
            else if(str[i].equals("q")) arr[16]++;
            else if(str[i].equals("r")) arr[17]++;
            else if(str[i].equals("s")) arr[18]++;
            else if(str[i].equals("t")) arr[19]++;
            else if(str[i].equals("u")) arr[20]++;
            else if(str[i].equals("v")) arr[21]++;
            else if(str[i].equals("w")) arr[22]++;
            else if(str[i].equals("x")) arr[23]++;
            else if(str[i].equals("y")) arr[24]++;
            else if(str[i].equals("z")) arr[25]++;
        }
        
        for(int i=0;i<26;i++)sb.append(arr[i]).append(" ");
        
        System.out.println(sb.toString());
    }
}