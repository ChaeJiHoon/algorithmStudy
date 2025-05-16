import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> hash = new HashSet<>();
        
        for(int i=0;i<10;i++){
            hash.add(Integer.parseInt(br.readLine())%42);
        }
        
        System.out.println(hash.size());
    }
}
