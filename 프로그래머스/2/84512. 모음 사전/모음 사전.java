import java.util.*;
class Solution {
    
    ArrayList<String> list;
    String[] str = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        list = new ArrayList<>();
        int answer = 0;
        dfs("");
        while(true){
            if(list.get(answer).equals(word)){
                break;
            }
            answer++;
        }
        
        return answer;
    }
    
    public void dfs(String cur){
        list.add(cur);
        if(cur.length() >= 5){
            return;
        }
        for(int i = 0; i < 5; i++){
            dfs(cur + str[i]);
        }
    }
}