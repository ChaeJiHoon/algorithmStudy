import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine().trim();  // 양쪽 공백 제거

        if (input.isEmpty()) {
            System.out.println(0);  // 빈 문자열이면 단어 0개
        } else {
            String[] words = input.split("\\s+");  // 하나 이상의 공백으로 분리
            System.out.println(words.length);
        }
    }
}
