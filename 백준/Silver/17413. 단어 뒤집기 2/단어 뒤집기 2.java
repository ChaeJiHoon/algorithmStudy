import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        String S = br.readLine();
        boolean trigger = true;

        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='<') {
                sb.reverse();
                answer.append(sb).append('<');
                sb.setLength(0);
                trigger = false;
                continue;
            }
            if(S.charAt(i)=='>') {
                answer.append(sb).append('>');
                sb.setLength(0);
                trigger = true;
                continue;
            }
            if(trigger){
                if(S.charAt(i)==' '){
                    sb.reverse();
                    answer.append(sb).append(" ");
                    sb.setLength(0);
                }else sb.append(S.charAt(i));

            }else{
                sb.append(S.charAt(i));
            }
        }
        sb.reverse();
        answer.append(sb);
        System.out.println(answer.toString().trim());

    }
}
