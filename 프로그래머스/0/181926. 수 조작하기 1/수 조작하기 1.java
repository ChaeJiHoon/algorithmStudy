class Solution {
    public int solution(int n, String control) {
        String[] str = control.split("");
        for(int i=0;i<control.length();i++){
            if(str[i].equals("w")){
                n += 1;
            }else if(str[i].equals("s")){
                n -= 1;
            }else if(str[i].equals("d")){
                n += 10;
            }else if(str[i].equals("a")){
                n -= 10;
            }    
        }
        return n;
    }
}