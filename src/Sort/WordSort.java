package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class WordSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> hash = new HashSet<>();

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            hash.add(br.readLine());
        }

        String[] strArr = new String[hash.size()];
        String[] ansArr = new String[hash.size()];
        int index = 0;

        for (String s : hash) {
            strArr[index] = s;
            index++;
        }

        Arrays.sort(strArr);

        index = 0;

        for(int i=0;i<50;i++){
            for(int j=0;j<strArr.length;j++){
                if(strArr[j].length()==i) {
                    ansArr[index] = strArr[j];
                    index++;
                }
            }
            if(index == strArr.length) break;
        }

        for (String s : ansArr) {
            System.out.println(s);
        }

    }
}
