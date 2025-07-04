import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++){
            if((100 - progresses[i]) % speeds[i] == 0){
                int day = (100 - progresses[i]) / speeds[i];
                q.add(day);
            } else{
                int day = ((100 - progresses[i]) / speeds[i]) + 1;
                q.add(day);
            }
        }
        
        int preDate = q.poll();
        int num = 1;
        while(!q.isEmpty()){
            if(q.element() <= preDate){
                q.poll();
                num++;
            } else {
                preDate = q.poll();
                list.add(num);
                num = 1;
            }
        }
        
        list.add(num);
        
        answer = list.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}