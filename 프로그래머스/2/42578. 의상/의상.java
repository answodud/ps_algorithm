import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] cloth : clothes){
            if(map.getOrDefault(cloth[1], 0) == 0){
               map.put(cloth[1], 1); 
            } else {
                map.replace(cloth[1], map.get(cloth[1]) + 1);
            }
        }
    
        
        for(String cloth : map.keySet()){
            answer = answer * (map.get(cloth) + 1);
        }
        
        answer -= 1;
        
        return answer;
    }
}