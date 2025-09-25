class Solution {
    
    String dic = "AEIOU";
    int cnt = 0;
    boolean found = false;
    String word;
    int answer = 0;
    
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
        
        if(found == true || cur.length() == 5){
            return;
        }
        
        for(int i = 0; i < dic.length(); i++){
            dfs(cur + dic.charAt(i));
        }
        
    }
}