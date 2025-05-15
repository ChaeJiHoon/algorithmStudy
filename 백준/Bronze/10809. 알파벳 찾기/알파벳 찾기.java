import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] arr = new int[26];

        for (int i=0;i<arr.length;i++) {
            arr[i] = -1;
        }
        for(int j=0;j<26;j++){
            for(int i=0;i<str.length();i++){
                if(str.charAt(i) == j+97){
                    arr[j] = i;
                    break;
                }
            }

        }


        for (int i=0;i<26;i++) {
            if(i==25)System.out.print(arr[i]);
            else System.out.print(arr[i] + " ");
            
        }
    }
}
