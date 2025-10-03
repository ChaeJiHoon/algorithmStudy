import java.util.*;

class Solution {
    static boolean[] userVisited;
    static String[] user;
    static String[] ban;
    static Set<String> uniq; 

    public int solution(String[] user_id, String[] banned_id) {
        user = user_id;
        ban = banned_id;
        userVisited = new boolean[user_id.length];
        uniq = new HashSet<>(); 

        dfs(0);

        return uniq.size(); 
    }

    static void dfs(int idx){
        if (idx>=ban.length){
            
            StringBuilder key = new StringBuilder();
            for (int i=0;i<user.length;i++)  if(userVisited[i]) key.append(i).append(',');
            uniq.add(key.toString());
            return;
        }

        for(int i=0;i<user.length;i++){
            if(userVisited[i]) continue;
            if(user[i].length() != ban[idx].length()) continue;

            boolean trigger = true;
            for (int j=0;j<user[i].length();j++){
                char c = ban[idx].charAt(j);
                if(c=='*') continue;
                if(c!=user[i].charAt(j)) {
                    trigger = false; 
                    break; 
                }
            }
            if(!trigger)continue;

            userVisited[i] = true;
            dfs(idx+1);
            userVisited[i] = false;
        }
    }
}


