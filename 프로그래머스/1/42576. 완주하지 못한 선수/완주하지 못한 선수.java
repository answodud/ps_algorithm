import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> part = new HashMap<>();
        
        for(String person : participant){
            if(part.getOrDefault(person, 0) != 0){
                part.put(person, part.get(person) + 1);
            } else {
                part.put(person, 1);
            }
        }
        
        for(String person : completion){
            if(part.getOrDefault(person, 0) != 0){
                part.replace(person, part.get(person) - 1);
            }
        }
        
        for(Map.Entry<String, Integer> entrySet : part.entrySet()){
            if(entrySet.getValue() != 0){
                return entrySet.getKey();
            }
        }
        
        
        
        return answer;
    }
}