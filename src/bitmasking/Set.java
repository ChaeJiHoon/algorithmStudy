package bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Set {
    public static void main(String[] args) throws IOException {
        boolean[] set = new boolean[21]; // 1~20
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            int x = 0;
            if (!cmd.equals("all") && !cmd.equals("empty")) {
                x = Integer.parseInt(st.nextToken());
            }

            switch (cmd) {
                case "add":
                    set[x] = true;
                    break;
                case "remove":
                    set[x] = false;
                    break;
                case "check":
                    sb.append(set[x] ? "1\n" : "0\n");
                    break;
                case "toggle":
                    set[x] = !set[x];
                    break;
                case "all":
                    for (int j = 1; j <= 20; j++) set[j] = true;
                    break;
                case "empty":
                    for (int j = 1; j <= 20; j++) set[j] = false;
                    break;
            }
        }

        System.out.print(sb.toString());
    }
}
