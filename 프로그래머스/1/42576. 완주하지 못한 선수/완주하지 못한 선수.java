import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String name : participant){
            if(map.getOrDefault(name, 0) == 0){
                map.put(name, 1);
            } else {
                map.replace(name, map.get(name) + 1);
            }
        }
        
        for(String name : completion){
            map.replace(name, map.get(name) - 1);
            if(map.get(name) == 0){
                map.remove(name);
            }
        }
        
        for(String str : map.keySet()){
            answer += str;
        }
        
        
        return answer;
    }
}