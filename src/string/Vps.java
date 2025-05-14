package string;
// 백준, 문자열, 실버 4
// 9012, 괄호
import java.util.Scanner;

public class Vps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            String str = sc.nextLine();
            System.out.println(vps(str));
        }

    }

    private static String vps(String str) {
        String[] strArr = str.split("");
        int count = 0;

        for(int i=0;i<strArr.length;i++){
            if(strArr[i].equals("(")){
                count++;
            }else count--;

            if(count<0) return "NO";
        }

        if(count == 0) return "YES";
        return "NO";
    }
}
