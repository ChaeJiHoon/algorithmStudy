package bigO;
import java.util.Scanner;
// 백준, 빅오표기법, 24264번
// 알고리즘 수업 - 알고리즘의 수행 시간
// 주의!!, 입력 크기를 잘봐라!
// 500000*500000 = 250000000000 이므로 오버플로우 발생 가능
// Long 써야한다!


public class Algorith_time3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long n = sc.nextLong();

        System.out.println(n*n);
        System.out.println(2);
    }
}
