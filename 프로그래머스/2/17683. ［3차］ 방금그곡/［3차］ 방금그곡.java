import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos){
        StringBuilder sb = new StringBuilder();
        PriorityQueue<MUSIC> pq = new PriorityQueue<>();

        ArrayList<String> mlist = tokenize(m);

        for (int i=0; i<musicinfos.length; i++){
            String[] strArr = musicinfos[i].split(",");
            int start = toMin(strArr[0]);
            int finish = toMin(strArr[1]);
            int playTime = finish - start;

            if (playTime < mlist.size()) continue;

            ArrayList<String> sheetTokens = tokenize(strArr[3]);
            ArrayList<String> slist = new ArrayList<>(playTime);
            
            int L = sheetTokens.size();
            
            for (int t = 0; t < (playTime + L - 1) / L; t++) {
                for (int x = 0; x < L && slist.size() < playTime; x++) {
                    slist.add(sheetTokens.get(x));
                }
            }

            boolean matched = false;
            for (int j = 0; j <= slist.size() - mlist.size(); j++) {
                if (!slist.get(j).equals(mlist.get(0))) continue;
                boolean ok = true;
                for (int k = 1; k < mlist.size(); k++) {
                    if (!slist.get(j + k).equals(mlist.get(k))) {
                        ok = false; break;
                    }
                }
                if (ok) { matched = true; break; }
            }

            if (matched) pq.add(new MUSIC(playTime, strArr[2], strArr[3], i));
        }

        String answer = "(None)";
        if (!pq.isEmpty()) answer = pq.poll().musicName;
        return answer;
    }

    static class MUSIC implements Comparable<MUSIC>{
        int playTime;
        String musicName;
        String sheet;
        int idx;
        MUSIC(int playTime, String musicName, String sheet, int idx){
            this.playTime = playTime;
            this.musicName = musicName;
            this.sheet = sheet;
            this.idx = idx;
        }
        @Override
        public int compareTo(MUSIC m){
            if (this.playTime == m.playTime) 
                return Integer.compare(this.idx, m.idx);
            return Integer.compare(m.playTime, this.playTime);
        }
    }

    private static int toMin(String hhmm){
        String[] hh = hhmm.split(":");
        return Integer.parseInt(hh[0]) * 60 + Integer.parseInt(hh[1]);
    }
    
    private static ArrayList<String> tokenize(String s){
        ArrayList<String> list = new ArrayList<>();
        for (int i=0; i<s.length(); i++){
            if (i+1 < s.length() && s.charAt(i+1) == '#') {
                list.add(s.substring(i, i+2)); 
                i++;
            } else {
                list.add(s.substring(i, i+1)); 
            }
        }
        return list;
    }
}
