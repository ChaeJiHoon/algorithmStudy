import java.io.*;
public class Main {
	public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        long temp = 0;
        for (int i = 0; i < input.length(); i++) {
        	temp = (temp * 10 + (input.charAt(i) - '0')) % 20000303;
        }
        
        System.out.println(temp);
    }
}
