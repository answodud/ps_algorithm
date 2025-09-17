import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes){
            if(map.getOrDefault(cloth[1], 0) != 0){
                map.replace(cloth[1], map.get(cloth[1]) + 1);
            } else {
                map.put(cloth[1], 1);
            }
        }
        
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            answer *= entry.getValue() + 1;    
        }
        
        return answer - 1;
    }
}