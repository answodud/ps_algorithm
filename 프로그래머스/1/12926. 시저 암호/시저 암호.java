class Solution {
    public String solution(String s, int n) {
        String answer = "";
        // A 시작 65 ~ 90
        // a 시작 97 ~ 123
        

        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= 65 && c <= 90){
                c = (char)((c - 'A' + n) % 26 + 'A');
                sb.append(c);
            } else if(c >= 97 && c <= 123){
                c = (char)((c - 'a' + n) % 26 + 'a');
                sb.append(c);
            } else {
                sb.append(c);
            }
        }
        
        
        return sb.toString();
    }
}