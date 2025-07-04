import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int cur_w = 0; // 현재 다리 무게
        int time = 0; // 시간
        
        Queue<Integer> q = new LinkedList<>(); // 다리 역할
        
        for(int i = 0; i < truck_weights.length; i++){
            int truck = truck_weights[i]; // 트럭 하나씩 빼기
            while(true){
                // 다리가 비어있는 경우
                if(q.isEmpty()){
                    // 트럭 다리위에 올리기
                    q.add(truck);
                    cur_w += truck;
                    time++;
                    break;
                } else if(q.size() == bridge_length){
                    // 다리가 꽉 찬 경우
                    // 트럭 하나 빼기
                    cur_w -= q.poll();
                } else {
                    // 다리에 자리가 남은 경우
                    if(truck + cur_w > weight){
                        // 트럭을 올리면 무게가 초과될 시
                        q.add(0);
                        time++;
                    } else {
                        // 트럭을 올려도 될 시
                        q.add(truck);
                        cur_w += truck;
                        time++;
                        break;
                    }
                }
            }
        }
        
        // 마지막으로 들어간 트럭도 다리를 빠져나와야 하므로
        answer = time + bridge_length;
        
        return answer;
    }
}