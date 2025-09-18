import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int scov : scoville){
            pq.offer(scov);
        }
        
        
        while(true){
            if(!pq.isEmpty()){
                int one = pq.poll();
                if(one >= K){
                    break;
                }
                if(!pq.isEmpty()){
                    int two = pq.poll();
                    int three = one + two*2;
                    answer++;
                    pq.offer(three);
                } else {
                    answer = -1;
                    break;
                }
            } else {
                answer = -1;
                break;
            }
        }
        
        
        return answer;
    }
}