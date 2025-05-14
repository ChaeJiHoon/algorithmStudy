package implement;
class NumberCons {
    public int solution(int n){
        int answer = 0;
        int sum = 0;

        for(int i=1;i<n/2+1;i++){
            for(int j=i;j<n;j++){
                sum += j;
                if(sum>n){
                    sum=0;
                    break;
                }
                if(sum == n){
                    answer++;
                    sum = 0;
                    break;
                }
            }
            sum = 0;
        }

        return answer;
    }
}
