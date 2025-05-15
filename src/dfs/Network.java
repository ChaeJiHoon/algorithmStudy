package dfs;
// 1. 비교 배열 2개를 만든다, 하나는 모두 0인 배열(arr), 하나는 모두 1인 배열(answer_arr)
// 2. 첫번째 네트워크를 살핀다, comuters[j][]값이 1인경우 arr[j]값을 1로 바꾼다.
// 3. 첫번째 네트워크를 다살펴 arr[j]의 값을 다 바꿨다면, dfs()함수를 1인 위치인 경우 모두 호출한다
/* 이때 넘겨주는 매개변수는 다음과 같다
    1. 다 바뀐 arr[]
    2.
    */
public class Network {
    static int answer = 0;
    static int[][] computers =
            {{1,1,0,0,0},
            {1,1,0,0,0},
            {0,0,1,0,0},
            {0,0,0,1,1},
            {0,0,0,1,1}};
    static int[][] comp =
            {
                    {1,1,0},
                    {1,1,1},
                    {0,1,1}};

    public static void main(String[] args) {
        System.out.println(Network(3,comp));

    }

    private static int Network(int n, int computers[][]){

        int[] arr = new int[n];
        int[] answer_arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = 0;
            answer_arr[i] = 1;
        }

        for(int j=0;j<n;j++){
            // com == computer[]
            int[] com = computers[j];
            if(arr[j]==0){
                dfs(arr, com);
                answer++;
            }
        }
        return answer;
    }

    private static void dfs(int[] arr, int[] com){
        for(int i=0;i<arr.length;i++){
            //arr[i]가 1이 아니면서, computers[i]는 1인경우 arr[i]를 1로 바꿔준다
            if(arr[i]!=1 && com[i]==1){
                arr[i] = 1;
            }
        }

        for(int j=0;j<arr.length;j++){
            // computers가 1이면서, 아직 호출 안항경우만 함수 실행
            if(com[j]==1&&arr[j]==0){
                dfs(arr, com);
            }
        }


    }
}
