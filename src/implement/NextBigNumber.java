package implement;

public class NextBigNumber {
    public int solution(int n){
        int answer = 0;
        int count1 = 0;
        int count2 = 0;
        String binary = Integer.toBinaryString(n);

        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i)=='1') count1++;
        }

        for(int i=n+1;i<n+10000;i++){
            String bin = Integer.toBinaryString(i);
            for(int j=0;j<bin.length();j++){
                count2++;
            }
            if(count1 == count2) answer = i;
        }

        return answer;
    }
}
