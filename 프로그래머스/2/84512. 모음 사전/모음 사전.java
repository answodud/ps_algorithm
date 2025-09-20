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
    
    public void dfs(String cur){
        if(cur.length() > 0){
            cnt++;
            if(cur.equals(word)){
                found = true;
                answer = cnt;
                return;
            }
        }
        if(cur.length() >= 5 || found == true){
            return;
        }
        
        for(int i = 0; i < 5; i++){
            if(cur.equals(word)){
                found = true;
                answer = cnt;
                return;
            }
            dfs(cur + str.charAt(i));
        }
    }
}