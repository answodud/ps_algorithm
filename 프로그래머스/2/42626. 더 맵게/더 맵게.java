import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int scov : scoville){
            pq.add(scov);
        }
        
        while(true){
            if(pq.isEmpty()){
                answer = -1;
                break;
            } else {
                int one = pq.poll();
                if(one >= K){
                    break;
                } else {
                    if(pq.isEmpty()){
                        answer = -1;
                        break;
                    } else {
                        int two = pq.poll();
                        int shake = one + two * 2;
                        answer += 1;
                        pq.add(shake);
                    }
                }
            }
        }
        
        
        return answer;
    }
}