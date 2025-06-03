import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        for(int i=0;i<n;i++){
            int a = Integer.parseInt(br.readLine());
            if(a == 0) stack.pop();
            else stack.add(a);
        }

        while(!stack.isEmpty()){
            sum += stack.pop();
        }

        System.out.println(sum);

    }

}
