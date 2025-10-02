import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        FileName[] fn = new FileName[files.length];
        int index = 0;
        
        for(String str : files){
            int start = 0;
            int finish = 0;
            
            for(int i=0;i<str.length();i++){
                if('0'<=str.charAt(i) && str.charAt(i) <= '9'){
                    
                    start = i;
                    for(int j=i;j<str.length();j++){
                        if(j+1>=str.length() || '0'>str.charAt(j+1) || str.charAt(j+1) >'9'){
                            finish = j;
                            break;
                        }
                    }
                    break;
                }
            }
            
            String head = str.substring(0,start);
            String number = str.substring(start,finish+1);
            String tail = str.substring(finish+1,str.length());
            
            fn[index] = new FileName(head, number, tail, index);
            index++;
        }
        
        Arrays.sort(fn);
        
        StringBuilder sb;
        String[] answer = new String[fn.length];
        for(int i=0;i<fn.length;i++){
            sb = new StringBuilder();
            sb.append(fn[i].head).append(fn[i].number).append(fn[i].tail);
            answer[i] = sb.toString();
        }

        
        return answer;
    }
    
    static class FileName implements Comparable<FileName>{
        String head;
        String hl;
        String number;
        int num;
        String tail;
        int idx;
        
        FileName(String head, String number, String tail,int idx){
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.idx = idx;
            this.hl = head.toLowerCase();
            this.num = Integer.parseInt(number);
        }
        
        @Override
        public int compareTo(FileName o){
            int c1 = this.hl.compareTo(o.hl);
            if(c1 != 0) return c1;
            
            int c2 = Integer.compare(this.num, o.num);
            if(c2 != 0) return c2;
            
            return Integer.compare(this.idx, o.idx);
        }
        
        
    } 
}