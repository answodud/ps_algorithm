import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        Deque<Character> dq = new ArrayDeque<>();
        for(int i = 0; i < number.length(); i++){
            char c = number.charAt(i);
            while(!dq.isEmpty() && dq.peekLast() < c && k > 0){
                dq.pollLast();
                k--;
            }
            dq.addLast(c);
        }
        
        while(k > 0){
            dq.pollLast();
            k--;
        }
        
        while(!dq.isEmpty()){
            answer += String.valueOf(dq.pollFirst());
        }
        
        
        return answer;
    }
}