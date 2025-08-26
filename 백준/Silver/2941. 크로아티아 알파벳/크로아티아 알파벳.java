import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        str= str.replaceAll("c=", "t");
        str= str.replaceAll("c-", "t");
        str= str.replaceAll("dz=", "t");
        str= str.replaceAll("d-", "t");
        str= str.replaceAll("lj", "t");
        str= str.replaceAll("nj", "t");
        str= str.replaceAll("s=", "t");
        str= str.replaceAll("z=", "t");

        System.out.println(str.length());
    }
}
