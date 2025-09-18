import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(String ope : operations){
            if(ope.charAt(0) == 'I'){
                int x = Integer.valueOf(ope.substring(2));
                maxHeap.offer(x);
                minHeap.offer(x);
            } else if(ope.charAt(0) == 'D'){
                int x = Integer.valueOf(ope.substring(2));
                if(minHeap.isEmpty() || maxHeap.isEmpty()){
                    continue;
                } else {
                    if(x == 1){
                    minHeap.remove(maxHeap.poll());
                    } else {
                   maxHeap.remove(minHeap.poll()); 
                    }
                }
            }
        }
        
        if(maxHeap.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        } else{
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }
    
        
        return answer;
    }
}