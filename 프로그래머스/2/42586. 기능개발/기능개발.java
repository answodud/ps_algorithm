import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++){
            if((100 - progresses[i]) % speeds[i] == 0){
                int num = (100 - progresses[i]) / speeds[i];
                q.add(num);
            } else {
                int num = (100 - progresses[i]) / speeds[i];
                q.add(num + 1);
            }
        }
        
        int num = 1;
        int prePro = q.poll();
        
        while(!q.isEmpty()){    
            if(prePro >= q.peek()){
                q.poll();
                num++;
            } else {
                list.add(num);
                prePro = q.poll();
                num = 1;
            }
        }
        
        list.add(num);
        answer = list.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}