import java.util.*;

class Solution {
    public String solution(String new_id) {
        // 1단계
        new_id = new_id.toLowerCase();

        // 2단계
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if (('a' <= c && c <= 'z') || ('0' <= c && c <= '9') || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }
        new_id = sb.toString();

        // 3단계 (수정)
        sb = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if (c == '.') {
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') continue;
            }
            sb.append(c);
        }
        new_id = sb.toString();

        // 4단계 (간결화)
        if (!new_id.isEmpty() && new_id.charAt(0) == '.') new_id = new_id.substring(1);
        if (!new_id.isEmpty() && new_id.charAt(new_id.length() - 1) == '.') new_id = new_id.substring(0, new_id.length() - 1);

        // 5단계
        if (new_id.isEmpty()) new_id = "a";

        // 6단계
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.charAt(14) == '.') new_id = new_id.substring(0, 14);
        }

        // 7단계
        while (new_id.length() < 3) {
            new_id += new_id.charAt(new_id.length() - 1);
        }

        return new_id;
    }
}
