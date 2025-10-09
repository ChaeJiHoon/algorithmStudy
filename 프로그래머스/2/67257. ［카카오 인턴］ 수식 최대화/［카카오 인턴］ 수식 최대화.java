import java.util.*;

class Solution {
    static ArrayList<Long> numList;
    static ArrayList<String> operatorList;
    static ArrayList<String> op;          // 등장한 연산자들
    static boolean[] checked;
    static long max;

    public long solution(String expression) {
        numList = new ArrayList<>();
        operatorList = new ArrayList<>();
        max = 0;

        // 숫자 파싱 (정규식으로 연산자 자리를 공백으로)
        String[] str = expression.replaceAll("[+\\-*]", " ").split(" ");
        for (String s : str) numList.add(Long.parseLong(s));

        HashSet<String> set = new HashSet<>();
        for (int i=0;i<expression.length();i++) {
            char c = expression.charAt(i);
            if(c=='-' || c=='+' || c=='*') {
                operatorList.add(String.valueOf(c));
                set.add(String.valueOf(c));
            }
        }

        op = new ArrayList<>(set); // 등장한 연산자들만
        checked = new boolean[op.size()];
        dfs(op.size(), 0, new ArrayList<>(numList), new ArrayList<>(operatorList));

        return max;
    }

    static void dfs(int len, int depth, ArrayList<Long> curNums, ArrayList<String> curOps) {
        if(depth==len){
            long val = Math.abs(curNums.get(0));
            max = Math.max(max, val);
            return;
        }

        for(int i=0;i<len;i++){
            if(checked[i]) continue;
            checked[i] = true;
            String oper = op.get(i); // 이번에 가장 높은 우선순위로 처리할 연산자

            ArrayList<Long> nextNums = new ArrayList<>(curNums);
            ArrayList<String> nextOps  = new ArrayList<>(curOps);

            applyOperator(oper, nextNums, nextOps); //선택한 연산자(oper)만 전체에 걸쳐 순서대로 적용하면서 리스트 축소 
            dfs(len, depth + 1, nextNums, nextOps);
            checked[i] = false;
        }
    }

    // ★ 선택한 연산자 oper를 리스트 전체에 대해 '왼→오' 순서로 모두 적용하며 리스트를 축소
    static void applyOperator(String oper, ArrayList<Long> nums, ArrayList<String> ops) {
        int idx = 0;
        while(idx<ops.size()){
            if (ops.get(idx).equals(oper)){
                long a = nums.get(idx);
                long b = nums.get(idx+1);
                long res;
                if(oper.equals("*")) res = a*b;
                else if (oper.equals("-")) res = a-b;
                else res = a+b;

                // 현재 idx에 res 덮어쓰고, 오른쪽 숫자/연산자 제거 → 리스트 축소
                nums.set(idx, res);
                nums.remove(idx+1);
                ops.remove(idx);
            }else idx++;
        }
    }
}
