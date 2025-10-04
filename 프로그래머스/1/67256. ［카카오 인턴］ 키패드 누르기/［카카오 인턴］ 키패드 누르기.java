import java.util.*;

class Solution {
    static int[] left = {3,0};
    static int[] right = {3,2};
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        for(int num : numbers){
            if(num==1 || num==4 || num==7){
                sb.append("L");
                left[1] = 0;
                if(num==1) left[0] = 0;
                if(num==4) left[0] = 1;
                if(num==7) left[0] = 2;
            }else if(num==3 || num==6 || num==9){
                sb.append("R");
                right[1] = 2;
                if(num==3) right[0] = 0;
                if(num==6) right[0] = 1;
                if(num==9) right[0] = 2;
            }else{
                int[] cur = matching(num);
                int ly = Math.abs(cur[0]-left[0]);
                int lx = Math.abs(cur[1]-left[1]);
                int ry = Math.abs(cur[0]-right[0]);
                int rx = Math.abs(cur[1]-right[1]);
                
                if((ly+lx)>(ry+rx)){
                    sb.append("R");
                    right[1] = 1;
                    if(num==2) right[0] = 0;
                    if(num==5) right[0] = 1;
                    if(num==8) right[0] = 2;
                    if(num==0) right[0] = 3; 
                }else if((ly+lx)<(ry+rx)){
                    sb.append("L");
                    left[1] = 1;
                    if(num==2) left[0] = 0;
                    if(num==5) left[0] = 1;
                    if(num==8) left[0] = 2;
                    if(num==0) left[0] = 3; 
                }else{
                    if(hand.equals("left")){
                        sb.append("L");
                        left[1] = 1;
                        if(num==2) left[0] = 0;
                        if(num==5) left[0] = 1;
                        if(num==8) left[0] = 2;
                        if(num==0) left[0] = 3; 
                    }else{
                        sb.append("R");
                        right[1] = 1;
                        if(num==2) right[0] = 0;
                        if(num==5) right[0] = 1;
                        if(num==8) right[0] = 2;
                        if(num==0) right[0] = 3; 
                    }
                }
                
            }
        }

        return sb.toString();
    }
    
    static int[] matching(int num){
        if(num==1) return new int[]{0,0};
        else if(num==2) return new int[]{0,1};
        else if(num==3) return new int[]{0,2};
        else if(num==4) return new int[]{1,0};
        else if(num==5) return new int[]{1,1};
        else if(num==6) return new int[]{1,2};
        else if(num==7) return new int[]{2,0};
        else if(num==8) return new int[]{2,1};
        else if(num==9) return new int[]{2,2};
        else return new int[]{3,1};
    }
}