package dfs_bfs;

class WordChange {
    // 문자열을 하나하나 잘라 저장, strArr에는 문자가 하나하나 다 저장된다.
    static String [][] strArr;

    // 방문 배열
    static boolean[] visited;

    // 단어 길이 저장 배열
    static int n;
    static int wN;

    static int count = 0;
    static int answer=0;

    public int wordChange(String begin, String target, String[] words){
        n = words.length;
        wN = words[0].length();
        visited = new boolean[n+1];
        strArr= new String[n+1][wN];

        //첫 배열은 방문할 필요 없으니
        visited[0] = true;

        // 처음 문자는 begin 잘라서 넣기
        strArr[0] = begin.split("");


        // 같은 문자가 있는 지 확인
        for (String word : words) {
            if(word.equals(target)) {
                count++;
            }
        }
        // count 가 증가하지 않았다면 같은 문자가 없는 거다, 실행 종료
        if(count==0) return 0;
        // 아닌 경우 진행
        count = 0;

        // 그 후 문자는 words의 문자 넣기
        for(int i=1;i<n+1;i++){
            String[] str = words[i].split("");
            for(int j=0;j<wN;j++){
                strArr[i][j] = str[j];
            }
        }

        for(int i=1;i<n+1;i++){
            // i가 num이 같으면 같은 단어니까 넘어감
            for(int j=0;j<wN;j++){
                // 문자열을 비교해서 문자가 다르면 count++
                if(!begin.equals(strArr[i][j])){
                    count++;
                }
            }
            // count 가 1이라는 소리는 문자가 하나만 다른거니까 바뀔 수 있다
            if(count==1){
                count=0;
                dfs(i);
            }
        }

        return answer;
    }

    public void dfs(int num){

        // 방문한 문자 인경우 종료
        if(visited[num]) return;
        visited[num] = true;

        for(int i=1;i<n+1;i++){
            // i가 num이 같으면 같은 단어니까 넘어감
            if(i!=num) continue;

            for(int j=0;j<wN;j++){
                // 문자열을 비교해서 문자가 다르면 count++
                if(!strArr[num][j].equals(strArr[i][j])){
                    count++;
                }
            }
            // count 가 1이라는 소리는 문자가 하나만 다른거니까 바뀔 수 있다
            if(count==1){
                dfs(i);
            }
        }



    }

}
