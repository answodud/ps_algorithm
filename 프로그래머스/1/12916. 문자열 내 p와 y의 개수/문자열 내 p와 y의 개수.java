class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        s = s.toLowerCase();
        int pcnt = 0;
        int ycnt = 0;
        for(char c : s.toCharArray()){
            if(c == 'p'){
                pcnt++;
            } else if(c == 'y'){
                ycnt++;
            }
        }
        
        if(pcnt == ycnt){
            return true;
        } else {
            return false;
        }
        
    }
}