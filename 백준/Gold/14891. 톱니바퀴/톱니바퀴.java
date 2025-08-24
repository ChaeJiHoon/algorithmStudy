import java.util.*;
import java.io.*;

public class Main {

    static List<Integer>[] list = new LinkedList[4];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<4;i++) list[i] = new LinkedList<>();

        for(int i=0;i<4;i++){
            String[] str = br.readLine().split("");
            for(int j=0;j<8;j++) list[i].add(Integer.parseInt(str[j]));
        }

        int K = Integer.parseInt(br.readLine());

        while(K-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int wheel = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            play(wheel, num);

            /*
            for(int i=0;i<4;i++){
                for(Integer l : list[i]){
                    System.out.print(l);
                }
                System.out.println();
            }*/
        }
        int answer = 0;

        if(list[0].get(0)==1) answer += 1;
        if(list[1].get(0)==1) answer += 2;
        if(list[2].get(0)==1) answer += 4;
        if(list[3].get(0)==1) answer += 8;

        System.out.print(answer);
    }

    static void play(int wh, int n){
        int[] ar = new int[4];

        switch(wh){
            case 1:
                if(!list[0].get(2).equals(list[1].get(6))) {
                    if(n==1) {
                        ar[0] = 1;
                        ar[1] = -1;
                    }
                    else {
                        ar[0] = -1;
                        ar[1] = 1;
                    }
                }else {
                    if(n==1) ar[0] = 1;
                    else ar[0] = -1;
                    break;
                }
                if(!list[1].get(2).equals(list[2].get(6))) {
                    if(ar[1]==1) ar[2]=-1;
                    else ar[2]=1;
                }else break;
                if(!list[2].get(2).equals(list[3].get(6))) {
                    if(ar[2]==1) ar[3]=-1;
                    else ar[3]=1;
                }
                break;

            case 2:
                if(!list[0].get(2).equals(list[1].get(6))) {
                    if(n==1) {
                        ar[0] = -1;
                        ar[1] = 1;
                    }
                    else {
                        ar[0] = 1;
                        ar[1] = -1;
                    }
                } else{
                    if(n==1) ar[1] = 1;
                    else ar[1] = -1;
                }
                if(!list[1].get(2).equals(list[2].get(6))) {
                    if(ar[1]==1) ar[2]=-1;
                    else ar[2]=1;
                }else break;
                if(!list[2].get(2).equals(list[3].get(6))) {
                    if(ar[2]==1) ar[3]=-1;
                    else ar[3]=1;
                }
                break;

            case 3:
                if(!list[2].get(2).equals(list[3].get(6))){
                    if(n==1) {
                        ar[2] = 1;
                        ar[3] = -1;
                    }
                    else {
                        ar[2] = -1;
                        ar[3] = 1;
                    }
                }else{
                    if(n==1) ar[2] = 1;
                    else ar[2] = -1;
                }
                if(!list[1].get(2).equals(list[2].get(6))) {
                    if(ar[2]==1) ar[1]=-1;
                    else ar[1]=1;
                }else break;
                if(!list[0].get(2).equals(list[1].get(6))) {
                    if(ar[1]==1) ar[0]=-1;
                    else ar[0]=1;
                }
                break;
            case 4:
                if(!list[2].get(2).equals(list[3].get(6))){
                    if(n==1) {
                        ar[2] = -1;
                        ar[3] = 1;
                    }
                    else {
                        ar[2] = 1;
                        ar[3] = -1;
                    }
                }else{
                    if(n==1) ar[3] = 1;
                    else ar[3] = -1;
                    break;
                }
                if(!list[1].get(2).equals(list[2].get(6))) {
                    if(ar[2]==1) ar[1]=-1;
                    else ar[1]=1;
                }else break;
                if(!list[0].get(2).equals(list[1].get(6))) {
                    if(ar[1]==1) ar[0]=-1;
                    else ar[0]=1;
                }
                break;
        }

        rotation(list,ar);
    }

    static void rotation(List<Integer>[] l, int[] ar){

        for(int i=0;i<4;i++){
            if(ar[i]==1)l[i].add(0,l[i].remove(l[i].size()-1));
            else if(ar[i]==-1)l[i].add(l[i].remove(0));
        }

    }
}
