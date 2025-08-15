import java.io.*;
import java.util.*;

public class Main {
    static class P {
        long x, y;
        P(long x, long y){ this.x = x; this.y = y; }
    }

    static long ccw(P a, P b, P c) {
        long v = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        if (v > 0) return 1;
        if (v < 0) return -1;
        return 0;
    }

    static boolean overlap1D(long a1, long a2, long b1, long b2) {
        if (a1 > a2) { long t=a1; a1=a2; a2=t; }
        if (b1 > b2) { long t=b1; b1=b2; b2=t; }
        return Math.max(a1, b1) <= Math.min(a2, b2);
    }

    static int intersect(P a, P b, P c, P d) {
        long ab_c = ccw(a,b,c);
        long ab_d = ccw(a,b,d);
        long cd_a = ccw(c,d,a);
        long cd_b = ccw(c,d,b);

        if (ab_c == 0 && ab_d == 0 && cd_a == 0 && cd_b == 0) {
            boolean ok = overlap1D(a.x, b.x, c.x, d.x) && overlap1D(a.y, b.y, c.y, d.y);
            return ok ? 1 : 0;
        }

        return (ab_c * ab_d <= 0 && cd_a * cd_b <= 0) ? 1 : 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        P a = new P(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        P b = new P(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        P c = new P(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        P d = new P(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        System.out.println(intersect(a,b,c,d));
    }
}
