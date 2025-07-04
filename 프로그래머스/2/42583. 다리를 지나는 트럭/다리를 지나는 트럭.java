import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        int cur_w = 0;
        int time = 0;
        
        for(int i = 0; i < truck_weights.length; i++){
            int truck = truck_weights[i];
            while(true){
                if(q.isEmpty()){
                    q.add(truck);
                    cur_w += truck;
                    time++;
                    break;
                } else if(q.size() == bridge_length){
                    cur_w -= q.poll();
                } else {
                    if(cur_w + truck > weight){
                        q.add(0);
                        time++;
                    } else {
                        q.add(truck);
                        time++;
                        cur_w += truck;
                        break;
                    }
                }
            }
        }
        
        answer = time + bridge_length;
        
        return answer;
    }
}