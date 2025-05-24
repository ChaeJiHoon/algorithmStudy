package greedy;
// 백준 | 그리디 | 실버 2
// 1541번 : 잃어버린 괄호
// 시간 제한 : 2초, 메모리 제한 : 128 MB
// 25.05.22
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class LostParentheses {
    static String str = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split("");

        Queue<Integer> mq = new LinkedList<>();     // 빼는 큐
        Queue<Integer> fq = new LinkedList<>();     // 더하는 큐
        int i2 = 0;

        for(int i=0;i<strArr.length;i++){
            if(strArr[i].equals("-")) {
                fq.add(func(str));
                i2 = i+1;
                break;
            }else if(strArr[i].equals("+")){
                fq.add(func(str));
            }else if(i == strArr.length-1) {
                str += strArr[i];
                fq.add(func(str));
                i2 = i+1;
            }else{
                str += strArr[i];
            }
        }

        for(int i=i2;i<strArr.length;i++){
            if(strArr[i].equals("-")||strArr[i].equals("+")) {
                mq.add(func(str));
            }else if (i == strArr.length-1){
                str += strArr[i];
                mq.add(func(str));
            } else{
                str += strArr[i];
            }
        }

        int f = 0;
        int m = 0;

        while(!fq.isEmpty()){
            f += fq.poll();
        }
        while(!mq.isEmpty()){
            m += mq.poll();
        }

        System.out.println(f-m);

    }

    static int func(String string){
        int num = Integer.parseInt(string);
        str = "";
        return num;
    }
}
