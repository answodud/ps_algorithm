class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        
        int l = s.length();
        if(l == 4 || l == 6){
            
            s = s.replaceAll("[^0-9]", ""); // 숫자 아닌거 제거
            if(l == s.length()){
                answer = true;
            }
        }
        
        return answer;
    }
}