class Solution {
    String str = "AEIOU";
    String word;
    int cnt = 0;
    int answer = 0;
    boolean found = false;
    public int solution(String word) {
        
        this.word = word;
        
        dfs("");
        
        return answer;
    }
    
    public void dfs(String s){
        if(s.equals(word)){
            found = true;
            answer = cnt;
            return;
        }
        
        cnt++;
        if(found || s.length() >= 5){
            return;
        }

        for(int i = 0; i < str.length(); i++){
            dfs(s + str.charAt(i));
        }
    }
}