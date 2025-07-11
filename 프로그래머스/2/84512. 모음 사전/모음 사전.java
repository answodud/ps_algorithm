import java.util.*;

class Solution {
    String str = "AEIOU";
    ArrayList<String> list = new ArrayList<>();
    
    public int solution(String word) {
        int answer = 0;
        dfs("");
        int i = 0;
        while(true){
            if(list.get(i).equals(word)){
                break;
            }
            i++;
        }
        
        return i + 1;
    }
    
    public void dfs(String cur){
        if(cur.length() >= 5){
            return;
        }
        for(int i = 0; i < 5; i++){
            list.add(cur + str.charAt(i));
            dfs(cur + str.charAt(i));
        }
    }
}