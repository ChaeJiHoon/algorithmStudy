package implement;
// 프로그래머스 Lv2 점프와 순간이동

public class JumpAndTeleport {
    public static void main(String[] args) {
        JumpAndTeleport cs = new JumpAndTeleport();
        System.out.println(cs.solution(49));
    }

    public int solution(int n){
        int num = n;
        int count = 1 ;
        while(num !=1)
            if(num%2 == 1) {        // 홀수인경우
                num  /= 2;
                count++;
            }else num /= 2;                  // 짝수인경우

        return count;
    }

}
