class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<my_string.length();i++) sb.append(my_string.charAt(my_string.length()-1-i));
        
        return sb.toString();
    }
}