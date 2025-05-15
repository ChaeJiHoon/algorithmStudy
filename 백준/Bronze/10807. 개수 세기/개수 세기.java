import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        String[] str = sc.nextLine().split(" ");

        int target = sc.nextInt();
        int answer = 0;

        for(int i=0;i<str.length;i++){
            if(target == Integer.valueOf(str[i])){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
