import java.util.*;

class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        int l = phone_number.length();
        for(int i=0;i<l;i++) {
            if(i>=l-4) sb.append(phone_number.charAt(i));
            else sb.append("*");
        }
        return sb.toString();
    }
}