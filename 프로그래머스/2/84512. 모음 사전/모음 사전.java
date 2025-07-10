import java.util.*;

class Solution {
    
    String[] str = {"A", "E", "I", "O", "U"};
    ArrayList<String> list = new ArrayList<>();
    
    public int solution(String word) {
        dfs(word, "");
        int answer = 0;
        while(true){
            if(list.get(answer).equals(word)){
                break;
            }
            answer++;
        }
        return answer;
        
    }
    
    public void dfs(String word, String cur){
        if(cur.length() > 5){
            return;
        }
        list.add(cur);
        for(int i = 0; i < 5; i++){
            dfs(word, cur + str[i]);
        }
    }
}