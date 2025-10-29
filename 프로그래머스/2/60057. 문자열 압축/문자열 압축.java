import java.util.*;

class Solution {
    public int solution(String s) {
        
        int answer = s.length();
        
        // size를 단위로 두기
        for(int size = 1; size <= s.length() / 2; size++){
            
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, size);
            int cnt = 1; // 같은 개수
            
            for(int j = size; j <= s.length(); j += size){
                if(j + size > s.length()){
                    sb.append(s.substring(j, s.length()));
                }
                String next = s.substring(j, Math.min(j + size, s.length()));
                if(prev.equals(next)){
                    cnt++;
                } else {
                    if(cnt == 1){
                        sb.append(prev);
                    } else {
                        sb.append(cnt).append(prev);
                    }
                    prev = next;
                    cnt = 1;
                }
            }
            answer = Math.min(answer, sb.length());
            
        }
        
        return answer;
        
        
    }
}