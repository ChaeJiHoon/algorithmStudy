import java.util.*;

// 들어온 순서를 기록하는 리스트<String[]>, [0] = 입장 or 퇴장(변경은 아님), [1] = id 
// 변경이 들어오면, HashMap<아이디, 닉네임>에 닉네임 변경
// 다 끝나면 순서 리스트에서 sb에 뽑아서 저장

class Solution {
    public String[] solution(String[] record) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String[]> orderList = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        
        for(String s : record){
            String[] sArr = s.split(" ");
            
            if(sArr[0].equals("Change")) map.put(sArr[1], sArr[2]);
            else{
                orderList.add(new String[]{sArr[0], sArr[1]});
                if(sArr[0].equals("Enter")) map.put(sArr[1], sArr[2]);
            }
        }
        
        String[] answer = new String[orderList.size()];
        int index = 0;
        
        for(String[] sA : orderList){
            sb.setLength(0);
            if(sA[0].equals("Enter")) sb.append(map.get(sA[1])).append("님이 들어왔습니다.");
            else sb.append(map.get(sA[1])).append("님이 나갔습니다.");
            answer[index++] = sb.toString();
        }
        
        return answer;
    }
}